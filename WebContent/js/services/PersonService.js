/**
 * Created by tim on 24-7-16.
 */
app.factory("Person", function($resource) {
    return $resource("api/persons/:id");
});

app.factory("Director", function($resource) {
    return $resource("api/persons/directors/:id");
});

app.factory("Actor", function($resource) {
    return $resource("api/persons/actors/:id");
});