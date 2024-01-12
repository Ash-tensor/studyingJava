package nestedclasssample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//NorthKorea는 IVisitable의 구현체가 아니기 때문에 방문할 수 없음.
public class NorthKorea extends Nation implements Dictatorship{

    private static final NorthKorea INSTANCE = new NorthKorea();
    public static String NAME = "Democratic People\'s Republic of Korea";
    public static String CAPITAL_CITY = "PYEONGYANG";
    public static String REGION = "ASIA";
    public static String LANGUAGE = "KOREAN";
    private List<NorthKorean> civilianList = new ArrayList<>();

    private NorthKorea() {
    }

    // NorthKorean은 ILibertyToMove의 구현체가 아니기 때문에
    // tourAborad와 submittingPassport 메소드가 없음
    public static NorthKorea getInstance() {
        return INSTANCE;
    }
    private void immigrationRegistration(Human human) {
        if (ImmigrationBureau.getInstance().immigrationScreening(human)) {
            System.out.println("NorthKorean immigration Bureau : immigration Accepted");
        }
        else {
            System.out.println("NorthKorean immigratoin Bureau : immigration Disaccepted");
        }
    }

    @Override
    public String getNAME() {
        return NorthKorea.NAME;
    }

    @Override
    public Bureau visitAdministartionBureau() {
        return AdministrationBureau.getInstance();
    }

    public static class AdministrationBureau extends Bureau {
        private static final AdministrationBureau INSTANCE = new AdministrationBureau();
        private AdministrationBureau() {}
        public static AdministrationBureau getInstance() {
            return INSTANCE;
        }
        public void birthRegistration(NorthKorean northKorean) {
            System.out.printf("북한 정부 : %s 출생신고 접수 완료\n", northKorean.name);
            NorthKorea.getInstance().civilianList.add(northKorean);
        }
        public void deathRegistration(NorthKorean northKorean) {
            NorthKorea.getInstance().civilianList.remove(northKorean);
        }
    }

    public static class ImmigrationBureau extends Bureau implements IImmigrationBureau {
        private List<Nation> dipolomaticNations = Arrays.asList();

        private static final ImmigrationBureau INSTANCE = new ImmigrationBureau();

        private ImmigrationBureau() {
        }

        public static ImmigrationBureau getInstance() {
            return INSTANCE;
        }
        public boolean visa(Human human) {
            System.out.println("visa");
            // 수교국 명단에 있으면 비자주기

            if(human instanceof ILibertyToMove) {
                System.out.printf("%s : 여권 있음\n", human.name);
                ILibertyToMove tourist = (ILibertyToMove) human;
                Nation passport = tourist.passportSubmitting();

                for(Nation nation : this.dipolomaticNations) {
//                if(human instanceof ILibertyToMove) {
//                    System.out.printf("%s : 여권 있음\n", human.name);
//                    ILibertyToMove tourist = (ILibertyToMove) human;
//                    Nation passport = tourist.passportSubmitting();

                    if (passport.equals(nation)) {
                        System.out.println("이민청 : 수교국 명단에 있음");
                        System.out.println("이민청 : 비자 발급 가능");
                        return true;
                    }
                }
            }
            System.out.println("이민청 : 수교국 명단에 없음");
            System.out.println("이민청 : 비자 발급 불가");
            return false;
        }

        public boolean immigrationScreening(Human human) {
            if(this.visa(human)) {
                if(human instanceof IImmigrant) {
                    System.out.println("이민청 :이민심사 승인");
                    return true;
                }
            }
            System.out.println("이민청 :이민심사 거절");
            return false;
        }
    }

    public static class NorthKorean extends Human{
        Boolean died;
        Nation nationality;

        public NorthKorean(String name, String sex, String region) {
            super(name, sex, region);
            System.out.printf("%s : %s Born\n", this.region, this.name);
        }
        public void birthRegistration() {
            Bureau administrationBureau = NorthKorea.getInstance().visitAdministartionBureau();
            System.out.printf("%s : visit %s Administration Bureau\n", this.name, this.region);
            AdministrationBureau northKoreaAdministartionBureau = (AdministrationBureau) administrationBureau;
            northKoreaAdministartionBureau.birthRegistration(this);
            this.nationality = NorthKorea.getInstance();
        }
        @Override
        public void death() {
            this.died = true;
        }
    }
}
