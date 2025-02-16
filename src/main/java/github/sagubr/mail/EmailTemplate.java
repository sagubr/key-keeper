package github.sagubr.mail;

public enum EmailTemplate {

    WELCOME {
        @Override
        public String content(String... params) {
            return "templates/email/welcome-template.html";
        }
    };

    public abstract String content(String... params);
}
