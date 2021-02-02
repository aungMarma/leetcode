class SingleTon {
    static SingleTon instance;

    private SingleTon() {

    }

    public static SingleTon getInstance() {
        // this runs fine
        // return new SingleTon();
        // but a user can call SingleTon.getInstance() again
        // and get A DIFFERENT SingleTon instance
        // what we want is to return the same singleTon instance 
        // no matter how many times a client subsequently call SingleTon.getInstance()

        // this codes and static SingleTon instance achieve that
        if (instance == null) {
            instance = new SingleTon();
        }
        return instance;
    }
}