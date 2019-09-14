package ru.job4j.tracker;

public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            switch (answer) {
                case  (ADD):
                    this.createItem();
                    break;
                case (SHOW):
                    this.showItems();
                    break;
                case (EDIT):
                    this.editItem();
                    break;
                case (DELETE):
                    this.deleteItem();
                    break;
                case (FINDBYID):
                    this.findItemById();
                    break;
                case (FINDBYNAME):
                    this.findItemByName();
                    break;
                case (EXIT):
                    exit = true;
                    this.exit();
                    break;
                default:
                    this.unknow();
                    break;
            }
        }
    }
    private void createItem() {
        /*System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");*/
    }
    private void showMenu() {
        /*System.out.println("Меню.");
        System.out.println("Для добавления элемента нажмите 0");
        System.out.println("Для вывода всех элементов нажмите 1");
        System.out.println("Для редактирования элемента нажмите 2");
        System.out.println("Для удаления заявки нажмите 3");
        System.out.println("Для нахождения заявки по ее id нажмите 4");
        System.out.println("Для нахождения заявки по ее имени нажмите 5");
        System.out.println("Для выхода нажмите 6");*/
    }
    public void showItems() {
        /*System.out.println("------------ Список заявок --------------");
        for (Item item:this.tracker.findAll()) {
            System.out.println(item.getName().concat("    №").concat(item.getId()));
        }
        System.out.println("-----------------------------------------");*/
    }
    public void editItem() {
        /*System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите имя id заявки :");
        Item item = this.tracker.findById(id);
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        item.setName(name);
        item.setDesc(desc);
        System.out.println("------------ Заявка с getId : " + item.getId() + "-----------");
        System.out.println("------------ Новое название : " + item.getName() + "-----------");
        System.out.println("------------ Новое описание : " + item.getDesc() + "-----------");
        System.out.println("-----------------------------------------");*/
    }
    public void deleteItem() {
        /*System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки на удаление :");
        this.tracker.delete(id);
        System.out.println("------------ Заявка удалена --------------");
        System.out.println("-----------------------------------------");*/
    }
    public void findItemById() {
        /*System.out.println("------------ Выбрать заявку --------------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        System.out.println("------------ Заявка с getId : " + item.getId() + "-----------");
        System.out.println("------------ Новое название : " + item.getName() + "-----------");
        System.out.println("------------ Новое описание : " + item.getDesc() + "-----------");
        System.out.println("-----------------------------------------");*/
    }
    public void findItemByName() {
        /*System.out.println("------------ Выбрать заявку по названию--------------");
        String name = this.input.ask("Введите название заявки :");
        Item[] items = this.tracker.findByName(name);
        for (Item item:items) {
            System.out.println("№".concat(item.getId()).concat("   ").concat(item.getName()));
            System.out.println("Описание: " + item.getDesc());
        }
        System.out.println("-----------------------------------------");*/
    }
    public void exit() {
        System.out.println("------------- Выход -------------");
    }
    public void unknow() {
        System.out.println("------------- Выбрана неверная команда -------------");
    }
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
        System.out.println("-----------------------------------------");
    }
}
