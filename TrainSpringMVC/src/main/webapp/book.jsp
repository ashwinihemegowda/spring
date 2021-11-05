<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <!DOCTYPE html>
<html>
<body>

<center>
<h1 color="green">Passenger Details</h1>
<br><br>
</center>
<form action="addpassenger">
<div align="center">

<table>
      <c:forEach var="train" items="${find}">
           <tr>
             <td>Train no:</td>
             <td><input type="text" name="train" value="${train.trainNo}" readonly></td>
           </tr>
           <tr>
             <td>Train name:</td>
             <td><input type="text" value=${train.trainName} name="name" readonly></td>
           </tr>
           <tr>
             <td>  Source:</td>
             <td><input type="text" value=${train.source} readonly></td>
           </tr>
           <tr>
             <td>destination:</td>
             <td><input type="text" value=${train.destination} readonly></td>
           </tr>
           
       </c:forEach>
 </table>
</div>
<div align="center">
Passenger Count:
 <select id="NumberOfPassengers"  name="passNo" placeholder="number of passengers"  required>
  <option value="1">one</option>
     <option value="2">two</option>
     <option value="3">three</option>
     <option value="4">four</option>
     </select>
     </div>


<div class="form-group">

</div>
            <form >
                <div class="col-sm-8" align="center">
                    <div class="form-group">
                        <div id="content">
                        </div>
                    </div>
                </div>
                <div class="form-group" align="center">
                            <input type="checkbox" name="terms" required><label>* I accept the <a href="#">Terms and Conditions</a></label>
                            <br>
                            <div id="content">

                            </div>

                        </div>
                <div class="col-sm-4" align ="center">
                    <div class="form-group">
                        <br><br>
                        <button class="btn btn-primary">Confirm</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


</form>
</body>
<script  src="https://code.jquery.com/jquery-3.6.0.js"   integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="   crossorigin="anonymous"></script>
    <script>
    $('#NumberOfPassengers').on('input',function(e){
       $('#content').html('');
       var val=$(this).val();
       for(let i = 1; i <= val; i++){
         $('#content').append('<br><label for="name">Name:</label>'+
                             '<input type="text" name="name'+i+'" id="name" class="trainInput" placeholder="Name">'+
                              '<label for="age">Age:</label>'+
                              '<input type="text" name="age'+i+'" id="age" class="trainInput" placeholder="Age">'+
                              '<label for="gender" >Gender:&emsp;</label>'+
                              '<select name="gender'+i+'" id="gender" >'+
                                   '<option value="">select</option>'+
                                   '<option value="M">Male</option>'+
                                   '<option value="F">Female</option>'+
                                   '</select>');
       }

    });

    </script>
    </html>