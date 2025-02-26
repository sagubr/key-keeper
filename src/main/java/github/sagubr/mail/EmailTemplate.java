package github.sagubr.mail;

public enum EmailTemplate {

    BEM_VINDO {
        @Override
        public String subject(String... params) {
            return "Bem vindo ao Guardião de Chaves";
        }

        @Override
        public String content(String... params) {
            return "templates/email/welcome-template.html";
        }
    },
    COBRANCA_EMAIL {
        @Override
        public String subject(String... params) {
            return "Notificação para devolução de Chaves";
        }

        @Override
        public String content(String... params) {
            return "templates/email/aviso-devolucao.html";
        }
    };

    public abstract String subject(String... params);

    public abstract String content(String... params);
}
