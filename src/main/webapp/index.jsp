<html>
    <head>
        <title>crystal-web</title>
        <script src="index.js"></script>
    </head>
    <body>
        <h1>crystal-web!</h1>
        <h2>In <b>com.sandc.crystal.web</b> package</h2>
        <p>This is a wrapper web application to access com.eyelit.crystal and its sub packages.<br/>
            It is a simple web application to demonstrate the usage of Crystal.<br/>
            This page is a simple JSP page of the 'web application'.</p>

<a href="hello">Click here to access HelloServlet</a><br/>
<a href="read-object">Click here to access ReadObject</a><br/>
<a href="test">Click here to access Test</a><br>
<a href="test-property?property=DataSource">Click here to access TestProperty</a><br>

<form>
    <label for="objectId">Object Id:</label>
    <input type="text" id="objectId" name="objectId"><br><br>
    <label for="number1">Number 1:</label>
    <input type="text" id="number1" name="number1"><br><br>
    <label for="number2">Number 2:</label>
    <input type="text" id="number2" name="number2"><br><br>
    <input type="submit" value="Submit" onclick="test()">
  </form> 
</body>
</html>
