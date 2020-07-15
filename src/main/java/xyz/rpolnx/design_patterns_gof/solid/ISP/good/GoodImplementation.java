package xyz.rpolnx.design_patterns_gof.solid.ISP.good;

class Document {
}

interface Printer {
    void print(Document d);
}

interface Faxxer {
    void fax(Document d);
}

interface Scanner {
    void scan(Document d);
}

interface ComposePrinter extends Printer, Faxxer, Scanner {
}

//Works same as before
class MultiFunctionPrinter implements ComposePrinter {

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

class OldPrinter implements Printer {

    @Override
    public void print(Document d) {
        System.out.println("Now i can only print");
    }
}

