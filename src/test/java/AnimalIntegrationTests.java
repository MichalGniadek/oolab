// Nie działa po labie 4
public class AnimalIntegrationTests {
//    public String[] run(String[] args) {
//        var animal = new Animal();
//        var directions = OptionsParser.parse(args);
//        return Arrays.stream(directions).map(dir -> {
//            animal.move(dir);
//            return animal.toString();
//        }).toArray(String[]::new);
//    }
//
//    @Test
//    void invalid() {
//        assertArrayEquals(
//                new String[]{},
//                run(new String[]{"a", "asd", "dfg", "qwe", "fg", "fb"})
//        );
//    }
//
//    @Test
//    void rotation() {
//        assertArrayEquals(
//                new String[]{"(2,2) Wschod", "(2,2) Poludnie", "(2,2) Wschod", "(2,2) Polnoc"},
//                run(new String[]{"r", "right", "l", "left"})
//        );
//    }
//
//    @Test
//    void position(){
//        var animal = new Animal();
//        assertTrue(animal.isAt(new Vector2d(2,2)));
//        animal.move(MoveDirection.FORWARD);
//        assertTrue(animal.isAt(new Vector2d(2,3)));
//        animal.move(MoveDirection.RIGHT);
//        assertTrue(animal.isAt(new Vector2d(2,3)));
//        animal.move(MoveDirection.RIGHT);
//        assertTrue(animal.isAt(new Vector2d(2,3)));
//        animal.move(MoveDirection.LEFT);
//        assertTrue(animal.isAt(new Vector2d(2,3)));
//        animal.move(MoveDirection.BACKWARD);
//        assertTrue(animal.isAt(new Vector2d(1,3)));
//        animal.move(MoveDirection.BACKWARD);
//        assertTrue(animal.isAt(new Vector2d(0,3)));
//        animal.move(MoveDirection.FORWARD);
//        assertTrue(animal.isAt(new Vector2d(1,3)));
//    }
//
//    @Test
//    void confinedInMap() {
//        assertArrayEquals(
//                new String[]{"(2,3) Polnoc", "(2,4) Polnoc", "(2,4) Polnoc"},
//                run(new String[]{"f", "forward", "f"})
//        );
//
//        assertArrayEquals(
//                new String[]{"(2,1) Polnoc", "(2,0) Polnoc", "(2,0) Polnoc"},
//                run(new String[]{"b", "backward", "b"})
//        );
//
//        assertArrayEquals(
//                new String[]{"(2,2) Wschod", "(3,2) Wschod", "(4,2) Wschod", "(4,2) Wschod"},
//                run(new String[]{"r", "f", "forward", "f"})
//        );
//
//        assertArrayEquals(
//                new String[]{"(2,2) Wschod", "(1,2) Wschod", "(0,2) Wschod", "(0,2) Wschod"},
//                run(new String[]{"r", "b", "backward", "b"})
//        );
//    }
//
//    @Test
//    void generalMovement() {
//        assertArrayEquals(
//                new String[]{"(2,3) Polnoc", "(2,4) Polnoc", "(2,4) Wschod", "(1,4) Wschod",
//                            "(0,4) Wschod", "(0,4) Wschod", "(0,4) Polnoc", "(0,4) Polnoc"},
//                run(new String[]{"f", "asd", "forward", "r", "b", "backward", "b", "left", "f"})
//        );
//    }
}
