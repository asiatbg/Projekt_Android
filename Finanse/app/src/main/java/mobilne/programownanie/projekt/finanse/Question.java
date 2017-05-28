package mobilne.programownanie.projekt.finanse;


public class Question {
        private int ID;
        private String QUESTION;
        private String[] option = new String[3];
        private String ANSWER;

        public Question() {
        }

        public Question(String QUESTION, String[] option, String ANSWER) {
            this.QUESTION = QUESTION;
            this.option[0] = option[0];
            this.option[1] = option[1];
            this.option[2] = option[2];
            this.ANSWER = ANSWER;
        }


        public String getQUESTION() {

            return QUESTION;
        }

        public String getOption(int i) {

            return option[i];
        }


        public String getANSWER() {

            return ANSWER;
        }


        public void setQUESTION(String QUESTION) {

            this.QUESTION = QUESTION;
        }

        public void setOption(int i, String option) {

            this.option[i] = option;
        }

        public void setANSWER(String ANSWER) {

            this.ANSWER = ANSWER;
        }



}
