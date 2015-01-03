$(document).ready(function () {
    $('#image').imgAreaSelect({
        onSelectEnd: function (img, selection) {
            $('input[name="x1"]').val(selection.x1);
            $('input[name="y1"]').val(selection.y1);
            $('input[name="x2"]').val(selection.x2);
            $('input[name="y2"]').val(selection.y2);
            $('input[name="width"]').val(selection.width);
            $('input[name="height"]').val(selection.height);
        }
    });
});