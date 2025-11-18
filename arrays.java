Integer[][] raggedIntegerArray = {
    {1, 2, null, 3},
    {4, null, 5}
};

for (int i = 0; i < raggedIntegerArray.length; i++) {
    for (int j = 0; j < raggedIntegerArray[i].length; j++) {
        if (raggedIntegerArray[i][j] == null) {
            System.out.print("  ");
        } else {
            System.out.print(raggedIntegerArray[i][j] + " ");
        }
    }
    System.out.println();
}