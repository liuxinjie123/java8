package com.java8.lambda;

import com.java8.model.Album;
import com.java8.model.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;

public class AlbumTest {
    public static void main(String[] args) {
        Album album = new Album();
        List<Track> trackList = new ArrayList<>();
        Track track = new Track();
        track.setName("hello").setTime(30L);
        trackList.add(track);

        track = new Track();
        track.setName("wow").setTime(100L);
        trackList.add(track);

        track = new Track();
        track.setName("miracle").setTime(99L);
        trackList.add(track);

        album.setName("Miracle Your Life").setTrackList(trackList);
        printAlbumTimeStatistics(album);
    }


    private static void printAlbumTimeStatistics(Album album) {
        LongSummaryStatistics summaryStatistics =
                album.getTrackList()
                .stream().mapToLong(track -> track.getTime())
                .summaryStatistics();

        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum=%d",
                summaryStatistics.getMax(),
                summaryStatistics.getMin(),
                summaryStatistics.getAverage(),
                summaryStatistics.getSum());
    }
}
