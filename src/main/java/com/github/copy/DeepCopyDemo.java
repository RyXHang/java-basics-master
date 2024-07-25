package copy;

public class DeepCopyDemo {
    public static void main(String[] args) {
        try {
            Address originalAddress = new Address("New York", "5th Avenue");
            Person originalPerson = new Person("Alice", 30, originalAddress);

            // 进行深拷贝
            Person deepCopiedPerson = (Person) originalPerson.clone();

            System.out.println("Original Person: " + originalPerson);
            System.out.println("Deep Copied Person: " + deepCopiedPerson);

            // 修改原始对象的地址
            originalPerson.getAddress().setCity("Los Angeles");
            originalPerson.getAddress().setStreet("Sunset Boulevard");

            System.out.println("After modifying original person:");
            System.out.println("Original Person: " + originalPerson);
            System.out.println("Deep Copied Person: " + deepCopiedPerson);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
