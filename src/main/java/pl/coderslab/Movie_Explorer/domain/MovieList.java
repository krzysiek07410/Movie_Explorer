package pl.coderslab.Movie_Explorer.domain;

public class MovieList {
    int page;
    Movie[] results;
    int total_results;
    int total_pages;

    public MovieList() {
    }

    public MovieList(int page, Movie[] results, int total_results, int total_pages) {
        this.page = page;
        this.results = results;
        this.total_results = total_results;
        this.total_pages = total_pages;
    }

    public int getPage() {
        return page;
    }

    public Movie[] getResults() {
        return results;
    }

    public int getTotal_results() {
        return total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setResults(Movie[] results) {
        this.results = results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}
