package exercicios;

public class AppAnimal {
    public static void main(String[] args) {
        GerenciaAnimal cadastro = new GerenciaAnimal();
        cadastro.incluiAnimal("Nina", "SRD", "Preta", 2017, "Wallace", "27331762");
        cadastro.incluiAnimal("Nero", "Bulldog", "Preta", 2019, "Rita", "27331762");
        cadastro.incluiAnimal("Dóris", "Golden", "Branca", 2019, "Rodrigo", "27331762");
        cadastro.incluiAnimal("Cacau", "SRD", "Preta", 2017, "Renata", "27331762");
        cadastro.incluiAnimal("Teo", "Shitzu", "Caramelo", 2018, "Rodrigo", "27331762");
        cadastro.incluiAnimal("Mel", "Golden", "Caramelo", 2015, "Renata", "27331762");
    

        System.out.println("Cadastro completo");
        System.out.println(cadastro.imprime());
        System.out.println("Proprietarios de SRD");
        System.out.println(cadastro.buscaDonosRaca("SRD"));
        System.out.println("Proprietarios de Goldens");
        System.out.println(cadastro.buscaDonosRaca("Golden"));
        System.out.println("Proprietarios de Bulldogs");
        System.out.println(cadastro.buscaDonosRaca("Bulldog"));

        
    }
}
