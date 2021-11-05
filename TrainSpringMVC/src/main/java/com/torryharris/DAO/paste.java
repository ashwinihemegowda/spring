////package com.torryharris.DAO;
////
////public class paste {
//    Passenger Count:
// <input id="NumberOfPassengers" type = "number" name="passNo" placeholder="number of passengers" min="1" max="6" required/>
//
//
//<div class="form-group">
//
//</div>
//            <form >
//                <div class="col-sm-8" align="center">
//                    <div class="form-group">
//                        <div id="content">
//                        </div>
//                    </div>
//                </div>
//                <div class="col-sm-4" align ="center">
//                    <div class="form-group">
//                        <br><br>
//                        <button class="btn btn-primary">Confirm</button>
//                    </div>
//                </div>
//            </form>
//        </div>
//    </div>
//</div>
//
//
//</form>
//</body>
//<script  src="https://code.jquery.com/jquery-3.6.0.js"   integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="   crossorigin="anonymous"></script>
//    <script>
//    $('#NumberOfPassengers').on('input',function(e){
//        $('#content').html('');
//        var val=$(this).val();
//        for(let i = 1; i <= val; i++){
//            $('#content').append('<br><label for="name">Name:</label>'+
//                    '<input type="text" name="name'+i+'" id="name" class="trainInput" placeholder="Name" required>'+
//                    '<label for="age">Age:</label>'+
//                    '<input type="text" name="age'+i+'" id="age" class="trainInput" placeholder="Age" required>'+
//                    '<label for="gender" >Gender:&emsp;</label>'+
//                    '<select name="gender'+i+'" id="gender" required>'+
//                    '<option value="">select</option>'+
//                    '<option value="M">Male</option>'+
//                    '<option value="F">Female</option>'+
//                    '</select>');
//        }
//
//    });
//</script>
////
////
////}
//
//
//import org.springframework.web.bind.annotation.GetMapping;
//
//@GetMapping("/take")
////    public String findTrain(Model mv) throws ParseException {
////
////
////        int trainNo=Integer.parseInt("trainNo");
////        String date=mv.getAttribute(date);
////        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
////        int count=Integer.parseInt("passNo");
////        List<Train>trainList= trainDAO.loadTrains(trainNo);
////        Ticket ticket=new Ticket(date1,trainDAO.getTrain(trainList));
////        for(int i=1;i<=count;i++) {
////            String name = request.getParameter("name" + i);
////            int age = Integer.parseInt(request.getParameter("age" + i));
////            char gender = request.getParameter("gender" + i).charAt(0);
////            ticket.addPassenger(name, age, gender);
////            count--;
////        }
////        String PNR=ticket.confirmTicket();
////        System.out.println("your pnr is"+PNR);
////        mv.addObject("PNR",PNR);
////        mv.setViewName("index.jsp");
////        return mv;
////
////    }
//@GetMapping("/show")
//public ModelAndView addPassenger(HttpServletRequest request,HttpServletResponse response) throws ParseException {
//        int num=Integer.parseInt("trainNo");
//        ModelAndView mv=new ModelAndView();
//        String PNR=null;
//
//        String date=request.getParameter("date");
//        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
//        String travelDate=sdf.format(date1);
//        List<Train>trainList= trainDAO.loadTrains(num);
//        System.out.println(travelDate);
//        mv.setViewName("book.jsp");
//        mv.addObject("find", trainList);
//        mv.addObject("pnr",PNR);
//        for(Train t:trainList)
//        {
//        char s=t.getSource().charAt(0);
//        char d=t.getDestination().charAt(0);
//        String pnr=""+s+""+d+""+travelDate+"";
//        PNR=pnr;
//        System.out.println(PNR);
//        }
//        System.out.println(PNR);
//        return mv;
//        }
//@GetMapping("/take")
//public ModelAndView show(HttpServletRequest request,HttpServletResponse response){
//        ModelAndView mv=new ModelAndView();
//        int trainNo=Integer.parseInt("trainNo");
//        List<Train>trainList= trainDAO.loadTrains(trainNo);
//        mv.addObject("find",trainList);
//        mv.setViewName("book.jsp");
//        return mv;
//        }
//
//
//        }

