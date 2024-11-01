public class Container {
    private int content;
    private int max;
    
    public Container() {
        this.content = 0;
        this.max = 100;
    }
    
    public int contains() {
        return this.content;
    }
    
    public void add(int amount) {
        if (amount > 0) {
            this.content += amount;
            if (this.content > this.max) {
                this.content = this.max;
            }
        }
    }
    
    public void remove(int amount) {
        if (amount > 0) {
            this.content -= amount;
            if (this.content < 0) {
                this.content = 0;
            }
        }
    }
    
   public String toString() {
       return this.content + "/" + this.max;
   }
}
