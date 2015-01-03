<html>
    <head>
        <title>Image crop with javascript and cloudinary</title>

        <link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="css/imgareaselect-default.css" />
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
        <script src="scripts/jquery.imgareaselect.pack.js"></script>
        <script src="scripts/jquery.imgareaselect.min.js"></script>
        <script src="scripts/jquery.imgareaselect.js"></script>
         <script src="scripts/app.js"></script>
    </head>
    <body>

       <form name="photo" action="crop.html" method="post" >
         <input type="hidden" name="id" value="${photoModel.id}"/>
         <input type="hidden" name="x1" value="" />
         <input type="hidden" name="y1" value="" />
         <input type="hidden" name="x2" value="" />
         <input type="hidden" name="y2" value="" />
         <input type="hidden" name="width" value="" />
         <input type="hidden" name="height" value="" />
         <input type="submit"  value="Crop" />
       </form>

       <img id="image" src = "${photoModel.url}" />

    </body>
</html>