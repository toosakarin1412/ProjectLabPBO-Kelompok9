package menu;
/**
 * Class Minuman, minuman memiliki 2 jenis yaitu minuman dingin dan minuman panas
 */
public class Minuman extends Menu {
    private boolean dingin; 

    /**
     * Set minuman menjadi dingin atau panas
     * @param dingin berupa boolean 
     */
    public void setDingin(boolean dingin){
        this.dingin = dingin;
    };

    /**
     * @return this.dingin mengembalikan nilai dingin atau panas
     */
    public boolean getDingin(){
        return this.dingin;
    };
};
