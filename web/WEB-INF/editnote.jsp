<%-- 
    Document   : editnote
    Created on : Sep 29, 2020, 9:53:03 AM
    Author     : 584893
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form action="" method="POST">
            Title: <input type="text" name="title" value="${note.title}" />
            <br>
            Contents: <textarea name="contents">${note.contents}</textarea>

            <input type="submit" value="Save" />
        </form>
    </body>
</html>
