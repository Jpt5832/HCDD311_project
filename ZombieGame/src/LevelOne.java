public class LevelOne {

    private String[] columnNames;
    private Object[][] level1Items; // = new Object[7][10];

    public Object LevelOne() {
        //Constructor that loads everything for level one
        columnNames = new String[] {"ItemID", "Category", "Name", "Description", "Quantity", "Value", "Image Path"};

        level1Items = new Object[][] {
                {"004", "Health", "mHP", "Medium health pack", 1, 25, "./src/images/mHP.png"},
                {"202", "Lives", "1up", "Increase lives by 1", 0, 1, "./src/images/1up.jpg"},
                {"901", "Map", "Level 1", "Map of Level 1", 1, 1, "./src/images/level1map.png"},
        };

        return level1Items;
    }

    public Object[] popItem() {
        // Check if the stack is already empty
        if (level1Items == null || level1Items.length == 0) {
            System.out.println("Stack Underflow: No items to remove.");
            return null;
        }

        /** Separate the item from the Object array */
        // Identify the "top" of the stack
        Object[] removedItem = level1Items[level1Items.length - 1];

        // Create a new array that is one size smaller
        Object[][] newArray = new Object[level1Items.length - 1][];

        // Copy all items except the last one into the new array
        for (int i = 0; i < level1Items.length - 1; i++) {
            newArray[i] = level1Items[i];
        }

        // Update the class reference to the new, smaller array
        level1Items = newArray;

        // Return the item that was removed (standard Stack behavior)
        return removedItem;
    }

}