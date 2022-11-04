public enum Season {
    //Перечисление, содержащее названия времен года.
    //Перечисление должно содержать переменную, содержащую среднюю температуру в каждом времени года.
    WINTER(-15), SPRING(15), SUMMER(25){
        @Override
        //переопределяем метод, возвращающий строку
        public String getDescription(){
            return "Теплое время года";
        }
    },
    AUTUMN(10);

    private int avgTemp; //ссоздаем переменную для средней температуры

    //создаем конструктор для переменной avgTemp (средней температуры)
    Season(int avgTemp){
        this.avgTemp=avgTemp;
    }

    //возвращаем значение переменной
    public int getAvgTemp() {
        return avgTemp;
    }

    //создаем метод, возвращающий строку
    public String getDescription(){
        return "Холодное время года";
    }
}
