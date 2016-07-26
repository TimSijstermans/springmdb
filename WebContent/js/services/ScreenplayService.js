/**
 * Created by tim on 24-7-16.
 */
app.factory("Screenplay", function($resource) {
    return $resource("api/screenplays");
});

app.factory("Movie", function($resource) {
    return $resource("api/screenplays/movies/:id");
});

app.factory("Series", function($resource) {
    return $resource("api/screenplays/series/:id");
});

app.factory("Episode", function($resource) {
    return $resource("api/screenplays/series/episode/:id");
});