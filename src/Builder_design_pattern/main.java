package Builder_design_pattern;

class User {
    private final String name;
    private final String email;
    private final int age;
    private final boolean newsletter;
    private final String role;


    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.newsletter = builder.newsletter;
        this.role = builder.role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", newsletter=" + newsletter +
                ", role='" + role + '\'' +
                '}';
    }

    //builder class
    public static class Builder {
        private String name;
        private String email;
        private int age;
        private boolean newsletter;
        private String role;

        // methods to set values
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder newsletter(boolean newsletter) {
            this.newsletter = newsletter;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        // build method
        public User build() {
            return new User(this);
        }
    }
}
public class main {
    public static void main(String[] args) {
        User u = new User.Builder()
                .name("Rishav")
                .email("rishav@ex.com")
                .age(26)
                .newsletter(true)
                .role("ADMIN")
                .build();

        System.out.println(u);

    }
}
