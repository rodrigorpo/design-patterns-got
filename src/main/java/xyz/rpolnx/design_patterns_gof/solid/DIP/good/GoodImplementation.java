package xyz.rpolnx.design_patterns_gof.solid.DIP.good;

public class GoodImplementation {
}

class ServiceImpl {
    private final SuchAHighLevelImplementation highLevel = new SuchAHighLevelImplementation(new RepositoryImpl());
    private final SuchAHighLevelImplementation highLevel2 = new SuchAHighLevelImplementation(new RepositoryImpl2());

    public void getSomeData() {
        System.out.println(highLevel.doSomeProcess());
        System.out.println(highLevel2.doSomeProcess());
    }
}

interface Repository {
    String getData();
}

class RepositoryImpl implements Repository {
    public String getData() {
        return "Implementation1: ";
    }
}

class RepositoryImpl2 implements Repository {
    public String getData() {
        return "Implementation2: ";
    }
}

class SuchAHighLevelImplementation {
    private final Repository repository;

    public SuchAHighLevelImplementation(Repository repository) {
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
        System.out.println("Now this system is depending from abstraction and not implementations");

        ServiceImpl service = new ServiceImpl();
        service.getSomeData();
    }
}
