package try_catch_with_resources;

import java.io.InputStreamReader;

public class TryCatchWithResourcesLegal {

    public static void main(String[] args) {
        System.out.println("Try-with-resources legal examples:");
        tryWithResourceSingleRes();
        tryWithResourcesMultipleRes();
        complexTryWithResources();
    }

    private static void tryWithResourceSingleRes() {
        try (MyResource writer = new MyResource()) {
            System.out.println("\n 1. One resource declared, no catch, no finally");
        }
    }

    private static void tryWithResourcesMultipleRes() {
        try ( AnotherResource anotherResource = new AnotherResource();
              MyResource writer = new MyResource() ) {
            System.out.println("\n 2. Multiple resources declared, no catch, no finally");
        }
    }

    private static void complexTryWithResources() {
        try ( MyResource myResource = new MyResource();
                AnotherResource anotherResource = new AnotherResource() ) {
            System.out.println("\n 3. Multiple resources declared, catch and finally blocks");
            throw new Exception();
        } catch (Exception e){
            System.out.println("\t > Catch");
        } finally {
            // my own finally block is always executed after the implicit one that close the resources declared inside try
            // in the reverse order in which they are declared
            System.out.println("\t > Finally");
        }
    }
}

class MyResource implements AutoCloseable {

    @Override
    public void close() {
        System.out.println("\t > Closed MyResource");
    }
}

class AnotherResource implements AutoCloseable {

    @Override
    public void close() {
        System.out.println("\t > Closed AnotherResource");
    }
}
