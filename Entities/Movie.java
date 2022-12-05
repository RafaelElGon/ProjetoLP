package Entities;

import java.util.Objects;

public class Movie {
    private String name;
    private String duration;
    private double scoring;
    private String MPArating;
    private String releaseDate;

    public Movie(String name, String duration, double scoring, String MPArating, String releaseDate){
        this.name = name;
        this.duration = duration;
        this.scoring = scoring;
        this.MPArating = MPArating;
        this.releaseDate = releaseDate;
    }
    public Movie(){
        this("", "", 0.0, "", "");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return getName().equals(movie.getName())
                && getDuration().equals(movie.getDuration())
                && getReleaseDate().equals(movie.getReleaseDate());
    }
    public String toString(){
        return "Nome do filme: "+ this.name
                + "\nDuração: "+ this.duration
                + "\nNota: "+ this.scoring
                + "\nClassificação Indicativa: "+ this.MPArating
                + "\nData de Lançamento: "+ this.releaseDate;
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDuration(), getReleaseDate());
    }

    public String getName() {
        return name;
    }

    public void setName(String nameInput) {
        this.name = nameInput;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String durationInput) {
        this.duration = durationInput;
    }

    public double getScoring() {
        return scoring;
    }

    public void setScoring(double scoringInput) {
        this.scoring = scoringInput;
    }

    public String getRating() {
        return MPArating;
    }

    public void setRating(String ratingInput) {
        this.MPArating = ratingInput;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDateInput) {
        this.releaseDate = releaseDateInput;
    }
}
