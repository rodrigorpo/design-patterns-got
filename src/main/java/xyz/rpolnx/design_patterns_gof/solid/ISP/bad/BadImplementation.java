package xyz.rpolnx.design_patterns_gof.solid.ISP.bad;

class Document {
}

interface Machine {
    void print(Document d);

    void fax(Document d);

    void scan(Document d);
}

class MultiFunctionPrinter implements Machine {

    @Override
    public void print(Document d) {
    }

    @Override
    public void fax(Document d) {
    }

    @Override
    public void scan(Document d) {
    }
}

class Runner {
    public static void main(String[] args) {
        System.out.println("The problem is that if we need only one method, we have to implement all methods." +
                "For videos purpose: if we have an OldFashionedPrinter we need to require at all");
    }
}