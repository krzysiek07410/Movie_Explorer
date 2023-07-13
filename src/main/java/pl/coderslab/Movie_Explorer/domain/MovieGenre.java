package pl.coderslab.Movie_Explorer.domain;

public enum MovieGenre {
    action(28),
    adventure(12),
    animation(16),
    comedy(35),
    crime(80),
    documentary(99),
    drama(18),
    family(10751),
    fantasy(14),
    history(36),
    horror(27),
    music(10402),
    mystery(9648),
    romance(10749),
    science_fiction(878),
    tv_movie(10770),
    thriller(53),
    war(10752),
    western(37);

    private final int id;

    MovieGenre(int id) {
        this.id = id;
    }

    public static MovieGenre getById(int id) {
        for (MovieGenre genre : MovieGenre.values()) {
            if (genre.id == id) {
                return genre;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

}
