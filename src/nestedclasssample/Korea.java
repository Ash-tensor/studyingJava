package nestedclasssample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// IVisitable 인터페이스를 구현해야만 Human 객체가 해당 Nation을 방문할 수 있음
public class Korea extends Nation implements Republic, IVisitable{

    // 싱글톤
    private static final Korea INSTANCE = new Korea();
    public static String NAME = "Republic Of Korea";
    public static String CAPITAL_CITY = "SEOUL";
    public static String REGION = "ASIA";
    public static String LANGUAGE = "KOREAN";

    //국가 리스트
    private List<Korean> civilianList = new ArrayList<>();

    private Korea() {
    }

    public static Korea getInstance() {
        return INSTANCE;
    }
    private void immigrationRegistration(Human human) {
        if (ImmigrationBureau.getInstance().immigrationScreening(human)) {
            System.out.println("한국 정부 : 이민 최종 승인");
        }
        else {
            System.out.println("한국 정부 : 이민 최종 거절");
        }
    }

    @Override
    public ImmigrationBureau visitImmigrationBureau() {
        return ImmigrationBureau.getInstance();
    }
    @Override
    public Bureau visitAdministartionBureau() {
        return AdministrationBureau.getInstance();
    }
    @Override
    public String getNAME() {
        return Korea.NAME;
    }

//정부 구현
    public static class AdministrationBureau extends Bureau {
        private static final AdministrationBureau INSTANCE = new AdministrationBureau();
        private AdministrationBureau() {}
        public static AdministrationBureau getInstance() {
            return INSTANCE;
        }
        public void birthRegistration(Korean korean) {
            System.out.printf("한국 정부 : %s 출생신고 접수 완료\n", korean.name);
            Korea.getInstance().civilianList.add(korean);
        }
        public void deathRegistration(Korean korean) {
            Korea.getInstance().civilianList.remove(korean);
        }
    }

    //이민청 구현, Bureau 추상클래스를 상속하고, IImmigrationBureau 인터페이스를 구현해 visa 발급,
    // 이민 신청등의 일(일반 Bureau가 아닌 이민청이 해야하는 일을 구현)
    public static class ImmigrationBureau extends Bureau implements IImmigrationBureau {

        //수교국 리스트를 생성, List는 Nation 추상클래스 받아 모든 Nation이 ListArray에 들어갈 수 있게함
        private List<Nation> dipolomaticNations = Arrays.asList(US.getInstance(), Korea.getInstance());

        private static final ImmigrationBureau INSTANCE = new ImmigrationBureau();

        private ImmigrationBureau() {
        }

        public static ImmigrationBureau getInstance() {
            return INSTANCE;
        }
        @Override
        public boolean visa(Human human) {
            System.out.println("visa");
            // 수교국 명단에 있으면 비자주기
//            human이 IlibertyToMove 구현체이면
            if(human instanceof ILibertyToMove) {
                System.out.printf("%s : 여권 있음\n", human.name);
                ILibertyToMove tourist = (ILibertyToMove) human;
                Nation passport = tourist.passportSubmitting();

            for(Nation nation : this.dipolomaticNations) {
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
        @Override
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

//    Korean은 Human이고 이동할 수 있는 자유가 있음
    public static class Korean extends Human implements ILibertyToMove{
        Boolean died;
        Nation nationality;

        public Korean(String name, String sex, String region) {
            super(name, sex, region);
            System.out.printf("%s : %s 출생\n", this.region, this.name);
        }
        public void birthRegistration() {
            Bureau administrationBureau = Korea.getInstance().visitAdministartionBureau();
            System.out.printf("%s : %s 한국 행정센터 방문\n", this.name, this.region);
            AdministrationBureau koreaAdministartionBureau = (AdministrationBureau) administrationBureau;
            koreaAdministartionBureau.birthRegistration(this);
            this.nationality = Korea.getInstance();
        }
        @Override
        public void death() {
            this.died = true;
        }

        @Override
        public void tourAbroad(Nation nation) {
            if(nation instanceof IVisitable) {
                System.out.printf("%s : %s 방문 가능.\n", this.name, nation.getNAME());
                System.out.printf("%s : %s 도착\n", this.name, nation.getNAME());
                IVisitable travelDestination = (IVisitable) nation;

                Bureau immigrationBureau = travelDestination.visitImmigrationBureau();

                if (immigrationBureau instanceof IImmigrationBureau) {
                    IImmigrationBureau IBureau = (IImmigrationBureau) immigrationBureau;

                    if(IBureau.visa(this)) {
                        this.region = nation.getNAME();
                    }
                }
            }
            else{
                System.out.printf("%s : 목적지는 방문할 수 없다.\n", this.name);
            }
        }
        @Override
        public Nation passportSubmitting() {
            System.out.printf("%s : 여권 제출.\n", this.name);
            return this.nationality;
        }

        public void Immigrate(Nation nation) {
            if (nation instanceof IVisitable) {
                IVisitable targetNation = (IVisitable) nation;

                Bureau targetNationBureau = targetNation.visitImmigrationBureau();
                IImmigrationBureau targetNationImmigrationBureau = (IImmigrationBureau) targetNationBureau;
                targetNationImmigrationBureau.immigrationScreening(this);

            }
        }
    }
}