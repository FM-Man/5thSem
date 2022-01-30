package miscellanious;

public class PageSize {
    private int height;
    private int width;
    private int padding;

    public PageSize(int height, int width, int padding) {
        this.height = height;
        this.width = width;
        this.padding = padding;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }
}
