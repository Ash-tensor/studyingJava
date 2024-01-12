package nestedclasssample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US extends Nation implements Republic, IVisitable{

    private static final US INSTANCE = new US();
    public static String NAME = "United States Of America";
    public static String CAPITAL_CITY = "WASHINTON";
    public static String REGION = "NA";
    public static String LANGUAGE = "ENGLISH";
    private List<American> civilianList = new ArrayList<>();

    private US() {
    }

    public static US getInstance() {
        return INSTANCE;
    }
    private void immigrationRegistration(Human human) {
        if (ImmigrationBureau.getInstance().immigrationScreening(human)) {
            System.out.println("US Government : Immigration Finally Accepted");
        }
        else {
            System.out.println("US Government : Immigration Finally Disaccepted");
        }
    }
    public String getNAME() {
        return US.NAME;
    }

    @Override
    public ImmigrationBureau visitImmigrationBureau() {
        return ImmigrationBureau.getInstance();
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
        public void birthRegistration(American american) {
            System.out.printf("US Administration Bureau : %s \'s birth registration Accepted\n", american.name);

            US.getInstance().civilianList.add(american);
        }
        public void deathRegistration(American american) {
            US.getInstance().civilianList.remove(american);
        }
    }

    public static class ImmigrationBureau extends Bureau implements IImmigrationBureau{
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

            if (human instanceof ILibertyToMove) {
                System.out.printf("%s : Having Passport \n", human.name);
                ILibertyToMove tourist = (ILibertyToMove) human;
                Nation passport = tourist.passportSubmitting();

            for(Nation nation : this.dipolomaticNations) {
//                if(human instanceof ILibertyToMove) {
//                    System.out.printf("%s : 여권 있음\n", human.name);
//                    ILibertyToMove tourist = (ILibertyToMove) human;
//                    Nation passport = tourist.passportSubmitting();

                    if (passport.equals(nation)) {
                        System.out.println("Immigration Bureau : Visa Waiver Program Partner");
                        System.out.println("Immigration Bureau : Visa Granted");
                        return true;
                    }
                }
            }
            System.out.println("Immigration Bureau : Not Visa Waiver Program Partner");
            System.out.println("Immigration Bureau : Visa not Granted");
            return false;
        }
        @Override
        public boolean immigrationScreening(Human human) {
            if(this.visa(human)) {
                if(human instanceof IImmigrant) {
                    System.out.println("Immigration Bureau : Immigration Accepted");
                    return true;
                }
            }
            System.out.println("Immigration Bureau : Immigration Disaccepted");
            return false;
        }
    }

    public static class American extends Human implements ILibertyToMove{
        Boolean died;
        Nation nationality;

        public American(String name, String sex, String region) {
            super(name, sex, region);
            System.out.printf("%s : %s Born\n", this.region, this.name);
        }
        public void birthRegistration() {
            Bureau administrationBureau = US.getInstance().visitAdministartionBureau();
            System.out.printf("%s : visit %s Administration Bureau\n", this.name, this.region);
            AdministrationBureau USAdministartionBureau = (AdministrationBureau) administrationBureau;
            USAdministartionBureau.birthRegistration(this);
            this.nationality = Korea.getInstance();
        }
        @Override
        public void death() {
            this.died = true;
        }

        @Override
        public void tourAbroad(Nation nation) {
            if(nation instanceof IVisitable) {
                System.out.printf("%s : %s can be visited.\n", this.name, nation.getNAME());
                System.out.printf("%s : Arrived at %s\n", this.name, nation.getNAME());
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
                System.out.printf("%s :Destination is not available to visit.\n", this.name);
            }
        }
        @Override
        public Nation passportSubmitting() {
            System.out.printf("%s : Submit Passport\n", this.name);
            return this.nationality;
        }
    }
}