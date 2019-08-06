package fit5042.tutex;
import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;
import java.util.Scanner;

/**
 *
 * TODO Exercise 1.3 Step 3 Complete this class. Please refer to tutorial instructions.
 * This is the main driver class. This class contains the main method for Exercise 1A
 * 
 * This program can run without the completion of Exercise 1B.
 * 
 * @author Jian
 */
public class RealEstateAgency {
    private String name;
    private final PropertyRepository propertyRepository;
    
    public RealEstateAgency(String name) throws Exception{
        this.name = name;
        this.propertyRepository = PropertyRepositoryFactory.getInstance();
    }
    
    public void createProperties() throws Exception{
        Property p1 = new Property(1, "address1", 150, 420000.00);
        Property p2 = new Property(2, "address2", 352, 360000.00);
        Property p3 = new Property(3, "address3", 800, 650000.00);
        Property p4 = new Property(4, "address4", 170, 435000.00);
        Property p5 = new Property(5, "address5", 60, 820000.00);
        this.propertyRepository.addProperty(p1);
        this.propertyRepository.addProperty(p2);
        this.propertyRepository.addProperty(p3);
        this.propertyRepository.addProperty(p4);
        this.propertyRepository.addProperty(p5);
        System.out.println("5 properties added successfully");
    }
    
    public void displayProperties() throws Exception{
        for (Property property: propertyRepository.getAllProperties())
        {
            System.out.println(property.toString());
        }
    }
    
    public void searchRepository() throws Exception{
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the ID of the property you want to search:");
        int inputId = console.nextInt();
        System.out.println(propertyRepository.searchPropertyById(inputId).toString());
        
    }
    public void run() throws Exception{
        createProperties();
        System.out.println("***************************************************************");
        displayProperties();
        System.out.println("***************************************************************");
        searchRepository();
    }
    public static void main(String[] args) throws Exception {
        RealEstateAgency realestateagency = new RealEstateAgency("RealEstateAgency");
        realestateagency.run();
    }
}
