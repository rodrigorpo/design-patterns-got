package xyz.rpolnx.design_patterns_gof.solid.DIP.bad;

class ServiceImpl {
    private final SuchAHighLevelImplementation highLevel = new SuchAHighLevelImplementation(new RepositoryImpl());

    public void getSomeData() {
        System.out.println(highLevel.doSomeProcess());
    }
}

class RepositoryImpl {
    public String getData() {
        return "";
    }
}

class SuchAHighLevelImplementation {
    private final RepositoryImpl repository;

    public SuchAHighLevelImplementation(RepositoryImpl repository) {
        this.repository = repository;
    }

    public String doSomeProcess() {
        String data = repository.getData();
        return parse(data);
    }

    private String parse(String data) {
        return data + "23";
    }
}

class Runner {
    public static void main(String[] args) {
        System.out.println("The classical example here is for not depending concrete implementation, but yet abstraction");
        System.out.println("Such a high-level module, doesn't need to know about the module to be created. Instead, the " +
                "child must do some rules for use it. This remember us interfaces!");

        ServiceImpl service = new ServiceImpl();
        service.getSomeData();
    }
}
