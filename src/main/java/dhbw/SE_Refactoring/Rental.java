package dhbw.SE_Refactoring;

class Rental {

    private final Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        setDaysRented(daysRented);
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    private void setDaysRented(int daysRented){
        if(daysRented <= 0){
            System.err.println("Days rented have to be larger than 0. Will be set to 1 automatically.");
            this.daysRented = 1;
            return;
        }
        this.daysRented = daysRented;
    }

    public double getPrice(){
        return movie.getPriceCode().getPrice(daysRented);
    }
}
