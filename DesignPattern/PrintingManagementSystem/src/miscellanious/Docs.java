package miscellanious;

public class Docs {
    private String content;
    private int numberOfPages;
    private PageSize pageSize;
    private String orientation;
    private double colorIntensity;
    /**
     * added these variables here from PrintMode because they are needed to specify a document not a print mode.
     * So these variables violated the Single Responsibility principle.
     * */

    public Docs(String content, int numberOfPages, PageSize pageSize, String orientation, double colorIntensity) {
        this.content = content;
        this.numberOfPages = numberOfPages;
        this.pageSize = pageSize;
        this.orientation = orientation;
        this.colorIntensity = colorIntensity;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public void setPageSize(PageSize pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public double getColorIntensity() {
        return colorIntensity;
    }

    public void setColorIntensity(double colorIntensity) {
        this.colorIntensity = colorIntensity;
    }

    public void decreaseColorIntensity(double ammount) {
        this.colorIntensity -= ammount;
    }
}
