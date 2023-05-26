
package SF;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import javafx.scene.control.skin.LabeledSkinBase;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;




import java.security.SecureRandom;

import static javafx.application.Platform.exit;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root1 = new Pane();
        BorderPane root2 = new BorderPane();
        Pane root3 = new Pane();
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Final Project");
        HBox hBox = new HBox(75);
        Button button1 = new Button("ورود");
        Button button2 = new Button("ثبت نام");
        hBox.getChildren().addAll(button1,button2);
        hBox.setPadding(new Insets(100));
        hBox.setAlignment(Pos.CENTER);
        root1.getChildren().add(hBox);
        Scene scene = new Scene(root1 ,350,250);
        button1.setOnMouseClicked(e ->{
            Button button3 = new Button("   ثبت   ");
            Button button24 = new Button("بازگشت");
            HBox hBox18 = new HBox(10);
            hBox18.getChildren().addAll(button24,button3);
            hBox18.setAlignment(Pos.CENTER);
            TextField textField = new TextField();
            textField.setMaxWidth(200);
            textField.setPromptText("کد ملی");
            TextField textField2 = new TextField();
            textField2.setMaxWidth(200);
            textField2.setPromptText("رمز عبور");
            root2.setPadding(new Insets(8));
            BorderPane.setAlignment(textField,Pos.CENTER);
            BorderPane.setAlignment(textField2,Pos.CENTER);
            BorderPane.setAlignment(button3,Pos.CENTER);
            root2.setTop(textField);
            root2.setCenter(textField2);
            root2.setBottom(hBox18);
            try {
                Scene scene2 = new Scene(root2, 350, 100);
                primaryStage.setScene(scene2);
                button24.setOnMouseClicked(e11 ->{
                    Main h = new Main();
                    try {
                        h.start(primaryStage);
                    }catch (Exception r7){

                    }
                });
                if(true) {
                    button3.setOnMouseClicked(e2 -> {
                        try
        {
       

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            Socket s = new Socket(ip, 7744);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            String massage = null;
                             massage = 1 + "," + textField.getText() + "," +textField2.getText();
                             
           
            dos.writeUTF(massage);
            dos.flush();

               
             String   received = dis.readUTF();
            
             if(received.equals("error")){
                 System.out.println("ورود با مشکل مواجه شده است.");
                 s.close();
             dis.close();
             dos.close();
                 exit();
            }
             else{
             System.out.printf("ورود با موفقیت انجام شد");
             s.close();
             dis.close();
             dos.close();
             }
        }catch(Exception m){
            m.printStackTrace();
            return ;
        }
                        String string;
                        string = textField.getText();
                        System.out.println(string);
                        Pane root4 = new Pane();
                        Button button4 = new Button("افتتاح حساب");
                        Button button5 = new Button("مشاهده حساب ها");
                        Button button6 = new Button("مدیریت حساب");
                        Button button7 = new Button("حساب های پرکاربرد");
                        Button button8 = new Button("انتقال وجه");
                        Button button9 = new Button("پرداخت قبض");
                        Button button10 = new Button("درخواست وام");
                        Button button11 = new Button("بستن حساب");
                        Button button12 = new Button("خروج از حساب");
                        button4.setPrefWidth(150);
                        button5.setPrefWidth(150);
                        button6.setPrefWidth(150);
                        button7.setPrefWidth(150);
                        button8.setPrefWidth(150);
                        button9.setPrefWidth(150);
                        button10.setPrefWidth(150);
                        button11.setPrefWidth(150);
                        button12.setPrefWidth(150);
                        HBox hBox1 = new HBox(10);
                        hBox1.getChildren().addAll(button4,button5);
                        HBox hBox2 = new HBox(10);
                        hBox2.getChildren().addAll(button6,button7);
                        HBox hBox3 = new HBox(10);
                        hBox3.getChildren().addAll(button8,button9);
                        HBox hBox4 = new HBox(10);
                        hBox4.getChildren().addAll(button10,button11);
                        HBox hBox5 = new HBox(10);
                        hBox5.getChildren().add(button12);
                        hBox5.setPadding(new Insets(0,0,0,80));
                        VBox vBox1 = new VBox(10);
                        vBox1.getChildren().addAll(hBox1,hBox2,hBox3,hBox4,hBox5);
                        vBox1.setPadding(new Insets(15,0,0,20));
                        vBox1.setAlignment(Pos.CENTER);
                        root4.getChildren().add(vBox1);
                        Scene scene3 = new Scene(root4, 350, 190);
                        primaryStage.setScene(scene3);
                        button12.setOnMouseClicked(e3 -> {
                            Main h = new Main();
                            try {
                                h.start(primaryStage);
                            }catch (Exception r6){

                            }
                        });
                        button7.setOnMouseClicked(e4 -> {
                                 try
        {
       

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            Socket s = new Socket(ip, 7744);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            String massage = null;
                             massage = "3.1,1" ;
                             
           
            dos.writeUTF(massage);
            dos.flush();
            
               
             String   received = dis.readUTF();
            
             if(received.equals("error")){
                 System.out.println("نشان دادن حساب های پرکاربرد با مشکل مواجه شده است.");
                 s.close();
             dis.close();
             dos.close();
                 exit();
            }
             else{
                 System.out.println("نشان دادن حساب های پرکاربرد با موفقیت انجام شد.");
                 System.out.print(received);
                 s.close();
             dis.close();
             dos.close();
                 exit();
             }

        }catch(Exception m){
            m.printStackTrace();
            return ;
        }
                        });

button11.setOnMouseClicked(e4 -> {
                            Pane root5 = new Pane();
                            TextField textField7 = new TextField();
                            textField7.setPromptText("رمز عبور");
                            textField7.setMinWidth(230);
                            TextField textField28 = new TextField();
                            textField28.setPromptText("حساب مقصد");
                            textField28.setMinWidth(230);
                            TextField textField14 = new TextField();
                            textField14.setMaxWidth(230);
                            textField14.setPromptText("شماره حساب");
                            Button button13 = new Button(" برای بستن حساب کلیک کنید ");
                           // Button button14 = new Button("بازگشت");
                            //button14.setOnMouseClicked(e16->{
                             //   Main h = new Main();
                              //  try {
                               //     h.start(primaryStage);
                                //}catch (Exception r20){
                                //}
                            //});
                           // HBox hBox6 = new HBox(10);
                          //  hBox6.getChildren().addAll(button14,button13);
                           // hBox6.setAlignment(Pos.CENTER);
                            textField7.setAlignment(Pos.CENTER);
                            textField14.setAlignment(Pos.CENTER);
                            textField28.setAlignment(Pos.CENTER);
                            VBox vbox2 = new VBox(10);
                            vbox2.getChildren().addAll(textField14,textField28,textField7,button13);
                            vbox2.setPrefWidth(250);
                            vbox2.setPadding(new Insets(10,0,0,25));
                            vbox2.setAlignment(Pos.CENTER);
                            root5.getChildren().add(vbox2);
                            Scene scene4 = new Scene(root5,280,150);
                              button13.setOnMouseClicked(e5 ->{
                                    try
                                {
                               
                        
                                    // getting localhost ip
                                    InetAddress ip = InetAddress.getByName("localhost");
                        
                                    Socket s = new Socket(ip, 7744);
                        
                                    // obtaining input and out streams
                                    DataInputStream dis = new DataInputStream(s.getInputStream());
                                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                                                    String massage = null;
                                                     massage = 7 + "," + textField14.getText() + "," +textField7.getText() + "," + textField28.getText() ;
                                                     
                                   
                                    dos.writeUTF(massage);
                                    dos.flush();
                        
                                       
                                     String   received = dis.readUTF();
                                    
                                     if(received.equals("error")){
                                         System.out.println("بستن حساب با مشکل مواجه شده است.");
                                         s.close();
                                     dis.close();
                                     dos.close();
                                         exit();
                                    }
                                     else{
                                         System.out.println("بستن حساب با موفقیت انجام شد.");
                                         s.close();
                                     dis.close();
                                     dos.close();

exit();
                                     }
                        
                                }catch(Exception m){
                                    m.printStackTrace();
                                    return ;
                                }
                                                    });
                            primaryStage.setScene(scene4);
                        });
                        button10.setOnMouseClicked(e8 ->{
                            Button button19 = new Button("بازگشت");
                            Button button20 = new Button("درخواست وام");
                            button20.setMinWidth(96);
                            button19.setMinWidth(96);
                            Pane root8 = new Pane();
                            Label l = new Label("مدت زمان وام");
                            Label l1 = new Label("مبلغ وام");
                            TextField textField15 = new TextField();
                            textField15.setMaxWidth(200);
                            textField15.setPromptText("مبلغ");
                            textField15.setAlignment(Pos.CENTER);
                            TextField textField18 = new TextField();
                            textField18.setMaxWidth(200);
                            textField18.setPromptText("شماره حساب");
                            textField18.setAlignment(Pos.CENTER);
                            // string array
                            String st[] = { "روزانه", "ماهانه", "سالانه" };

                            // create a choiceBox
                            ChoiceBox c = new ChoiceBox(FXCollections.observableArrayList(st));

                            // add a listener
                            /*c.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

                                // if the item of the list is changed
                                public void changed(ObservableValue ov, Number value, Number new_value)
                                {

                                    // set the text for the label to the selected item
                                    l1.setText(st[new_value.intValue()] + " selected");
                                }
                            });*/

                            // add ChoiceBox
                            HBox hBox9 = new HBox(68);
                            hBox9.getChildren().addAll(c,l);
                            HBox hBox10 = new HBox(10);
                            hBox10.getChildren().addAll(textField15,l1);
                            HBox hBox11 = new HBox(10);
                            hBox11.getChildren().addAll(button19,button20);
                            VBox vBox4 = new VBox(10);
                            vBox4.getChildren().addAll(hBox9,hBox10,textField18,hBox11);
                            vBox4.setAlignment(Pos.CENTER);
                            root8.getChildren().add(vBox4);
                            vBox4.setPadding(new Insets(20));
                            root8.setPadding(new Insets(20));
                            try {
                                Scene scene7 = new Scene(root8,240,160);
                                primaryStage.setScene(scene7);
                            }catch(Exception r3){
                                primaryStage.setScene(scene3);
                            }
                            button20.setOnMouseClicked(e9 ->{
                          try
                               {
       

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            Socket s = new Socket(ip, 7744);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            String massage = null;
                            String kind ;
                            if(c.getValue().equals("روزانه"))
                                kind="DAILY";
                            else if(c.getValue().equals("ماهانه"))
                                kind="MONTHLY";
                            else
                                kind="WEEKLY";
                             massage = 6 + "," + textField18.getText() + "," +textField15.getText() + "," + kind;
                             
           
            dos.writeUTF(massage);
            dos.flush();

               
             String   received = dis.readUTF();
            
             if(received.equals("error")){
                 System.out.println("گرفتن وام با مشکل مواجه شده است.");
                 s.close();
             dis.close();
             dos.close();
                 exit();
            }
             else{
                 System.out.println("گرفتن وام با موفقیت انجام شد.");
                 s.close();
             dis.close();
             dos.close();
                 exit();
             }

        }catch(Exception m){
            m.printStackTrace();
            return ;
        }
                            });
                        });
                        button9.setOnMouseClicked(e6 ->{
                            BorderPane root6 = new BorderPane();
                            Button button15 = new Button("پرداخت");
                            Button button16 = new Button("بازگشت");
                            HBox hBox7 = new HBox(10);
                            hBox7.getChildren().addAll(button16,button15);
                            hBox7.setAlignment(Pos.CENTER);
                            TextField textField16 = new TextField();
                            textField16.setMaxWidth(200);
                            textField16.setPromptText("شماره حساب");
                            TextField textField17 = new TextField();
                            textField17.setMaxWidth(200);
                            textField17.setPromptText("رمز");
                            TextField textField8 = new TextField();
                            textField8.setMaxWidth(200);
                            textField8.setPromptText("شناسه قبض");
                            TextField textField9 = new TextField();
                            textField9.setMaxWidth(200);
                            textField9.setPromptText("مبلغ پرداخت");
                            VBox vBox5 =new VBox(10);
                            vBox5.getChildren().addAll(textField16,textField17,textField8,textField9);
                            vBox5.setAlignment(Pos.CENTER);
                            BorderPane.setAlignment(vBox5,Pos.CENTER);
                            BorderPane.setAlignment(hBox7,Pos.CENTER);
                            root6.setPadding(new Insets(8));
                            root6.setTop(vBox5);
                            root6.setBottom(hBox7);
                            try {
                                Scene scene5 = new Scene(root6, 300, 180);
                                primaryStage.setScene(scene5);
                            }catch(Exception r3){
                                primaryStage.setScene(scene3);
                            }
                            button15.setOnMouseClicked(e7 ->{
                                  try
        {
       

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            Socket s = new Socket(ip, 7744);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            String massage = null;
                             massage = 5 + "," + textField16.getText() + "," +textField9.getText() + "," + textField17.getText() ;
                             
           
            dos.writeUTF(massage);
            dos.flush();

               
             String   received = dis.readUTF();
            
             if(received.equals("error")){
                 System.out.println("پرداخت قبض با مشکل مواجه شده است.");
                 s.close();
             dis.close();
             dos.close();
                 exit();
            }
             else{
                 System.out.println("پرداخت قبض با موفقیت انجام شد");
                 s.close();
             dis.close();
             dos.close();
                 exit();
             }

        }catch(Exception m){
            m.printStackTrace();
            return ;
        }
                            });
                        });
                        button8.setOnMouseClicked(e6 ->{
                            BorderPane root7 = new BorderPane();
                            Button button17 = new Button("انتقال");
                            Button button18 = new Button("بازگشت");
                            HBox hBox8 = new HBox(10);
                            hBox8.getChildren().addAll(button18,button17);
                            hBox8.setAlignment(Pos.CENTER);
                            TextField textField10 = new TextField();
                            textField10.setMaxWidth(200);
                            textField10.setPromptText("مبلغ");
                            TextField textField11 = new TextField();
                            textField11.setMaxWidth(200);
                            textField11.setPromptText("شماره حساب مبداء");
                            TextField textField12 = new TextField();
                            textField12.setMaxWidth(200);
                            textField12.setPromptText("شماره حساب مقصد");
                            TextField textField13 = new TextField();
                            textField13.setMaxWidth(200);
                            textField13.setPromptText("رمز");
                            root7.setPadding(new Insets(8));
                            VBox vBox3 =new VBox(10);
                            vBox3.getChildren().addAll(textField10,textField11,textField12,textField13);
                            vBox3.setAlignment(Pos.CENTER);
                            BorderPane.setAlignment(vBox3,Pos.CENTER);
                            BorderPane.setAlignment(hBox8,Pos.CENTER);
                            root7.setTop(vBox3);
                            root7.setBottom(hBox8);
                            try {
                                Scene scene6 = new Scene(root7, 300, 180);
                                primaryStage.setScene(scene6);
                            }catch(Exception r3){
                                primaryStage.setScene(scene3);
                            }
                             button17.setOnMouseClicked(e7 ->{
                               try
        {
       

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            Socket s = new Socket(ip, 7744);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            String massage = null;
                             massage = 4 + "," + textField10.getText() + "," +textField11.getText() + "," + textField12.getText() + "," + textField13.getText();
                             
           
            dos.writeUTF(massage);
            dos.flush();

               
             String   received = dis.readUTF();
            
             if(received.equals("error")){
                 System.out.println("انتقال وجه با مشکل مواجه شده است.");
                 s.close();
             dis.close();
             dos.close();
                 exit();
            }
             else{
                 System.out.println("انتقال وجه با موفقیت انجام شد");
                 s.close();
             dis.close();
             dos.close();
                 exit();
             }

        }catch(Exception m){
            m.printStackTrace();
            return ;
        }
                        });
                        });
                       
                        button6.setOnMouseClicked(e12 ->{
                            BorderPane root11 = new BorderPane();
                            Button button25 = new Button("اضافه کردن حساب به حساب های پرکاربرد");
                            Button button26 = new Button("مشاهده اطلاعات حساب");
                            Button button27 = new Button("تعیین نام مستعار حساب");
                            Button button28 = new Button("بازگشت");
                            button25.setMinWidth(200);
                            button26.setMinWidth(200);
                            button27.setMinWidth(200);
                            button28.setMinWidth(200);
                            VBox vBox7 =new VBox(10);
                            vBox7.getChildren().addAll(button25,button26,button27,button28);
                            vBox7.setAlignment(Pos.CENTER);
                            root11.setCenter(vBox7);
                            try {
                                Scene scene11 = new Scene(root11, 300, 220);
                                primaryStage.setScene(scene11);
                                button25.setOnMouseClicked(e13 ->{
                                    Button button31 = new Button("بازگشت");
                                    Button button32 = new Button("افزودن به حساب پرکاربرد");
                                    button31.setMinWidth(90);
                                    button32.setMinWidth(90);
                                    Pane root13 = new Pane();
                                    Label l11 = new Label("شماره حساب");
                                    TextField textField22 = new TextField();
                                    textField22.setMaxWidth(200);
                                    textField22.setPromptText("شماره حساب");
                                    textField22.setAlignment(Pos.CENTER);
                                    HBox hBox21 = new HBox(20);
                                    hBox21.getChildren().addAll(textField22,l11);
                                    HBox hBox22 = new HBox(10);
                                    hBox22.getChildren().addAll(button31,button32);
                                    VBox vBox8 = new VBox(10);
                                    vBox8.getChildren().addAll(hBox21,hBox22);
                                    vBox8.setAlignment(Pos.CENTER);
                                    root13.getChildren().add(vBox8);
                                    vBox8.setPadding(new Insets(20));
                                    root13.setPadding(new Insets(20));
                                    button31.setOnMouseClicked(e16->{
                                        Main h = new Main();
                                        try {
                                            h.start(primaryStage);
                                        }catch (Exception r20){
                                        }
                                    });
                                    try {
                                        Scene scene12 = new Scene(root13,270,90);
                                        primaryStage.setScene(scene12);
                                    }catch(Exception r7){
                                        primaryStage.setScene(scene11);
                                    }
                                    button32.setOnMouseClicked(e16->{
                                            try
        {
       

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            Socket s = new Socket(ip, 7744);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            String massage = null;
                             massage = "8" + "," + textField22.getText()  ;
                             
           
            dos.writeUTF(massage);
            dos.flush();

               
             String   received = dis.readUTF();
            
             if(received.equals("error")){
                 System.out.println("اضافه شدن حساب به حساب های پرکاربرد با مشکل مواجه شده است");
                 s.close();
             dis.close();
             dos.close();
                 exit();
            }
             else{
                 System.out.println("اضافه شدن حساب به حساب های پرکاربرد با موفقیت انجام شد");
                 System.out.print(received);
                 s.close();
             dis.close();
             dos.close();
                 exit();
             }
 
        }catch(Exception m){
            m.printStackTrace();
            return ;
        }
                                    });
                                });
                                button26.setOnMouseClicked(e14 -> {
                                    BorderPane root14 = new BorderPane();
                                    TextField textField24 = new TextField();
                                    textField24.setPromptText("شماره حساب");
                                    textField24.setMaxWidth(200);
                                    textField24.setAlignment(Pos.CENTER);
                                    TextField textField23 = new TextField();
                                    textField23.setPromptText("رمز حساب");
                                    textField23.setAlignment(Pos.CENTER);
                                    textField23.setMaxWidth(200);
                                    Button button33 = new Button("بازگشت");
                                    Button button34 = new Button("   ثبت   ");
                                    HBox hBox23 = new HBox(10);
                                    hBox23.getChildren().addAll(button33,button34);
                                    hBox23.setAlignment(Pos.CENTER);
                                    root14.setPadding(new Insets(10));
                                    root14.setTop(textField24);
                                    root14.setCenter(textField23);
                                    root14.setBottom(hBox23);
                                    button34.setOnMouseClicked(e15 -> {
                                         try
        {
       

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            Socket s = new Socket(ip, 7744);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            String massage = null;
                             massage = "3.0" + "," + textField24.getText() + "," + textField23.getText();
                             
           
            dos.writeUTF(massage);
            dos.flush();

               
             String   received = dis.readUTF();
            
             if(received.equals("error")){
                 System.out.println("نشان دادن اطلاعات حساب با مشکل مواجه شده است.");
                 s.close();
             dis.close();
             dos.close();
                 exit();
            }
             else{
                 System.out.println("نشان دادن اطلاعات حساب با موفقیت انجام شد");
                 System.out.print(received);
                 s.close();
             dis.close();
             dos.close();
                 exit();
             }
 
        }catch(Exception m){
            m.printStackTrace();
            return ;
        }
                                         
                                    });
                                    try {
                                        Scene scene14 = new Scene(root14,220,100);
                                        primaryStage.setScene(scene14);
                                    }catch(Exception r7){
                                        primaryStage.setScene(scene11);
                                    }
                                    if(false) {

                                    }
                                    });
                                  button27.setOnMouseClicked(e20->{
                                    TextField textField25 = new TextField();

                                    TextField textField27 = new TextField();
                                    textField25.setPromptText("شماره حساب");

                                    textField27.setPromptText("نام مستعار");
                                    textField25.setAlignment(Pos.CENTER);
                                    textField27.setAlignment(Pos.CENTER);
                                    HBox hbox27 = new HBox(10);
                                    Button button36 = new Button("بازگشت");
                                    Button button37 = new Button("تعیین نام مستعار");
                                    hbox27.getChildren().addAll(button36,button37);
                                    hbox27.setAlignment(Pos.CENTER);
                                    VBox vBox10 = new VBox(10);
                                    vBox10.getChildren().addAll(textField25,textField27,hbox27);
                                    vBox10.setAlignment(Pos.CENTER);
                                    Pane root16 = new Pane();
                                    vBox10.setPadding(new Insets(15,0,0,15));
                                    root16.getChildren().add(vBox10);
                                    try {
                                        Scene scene15 = new Scene(root16,200,120);
                                        primaryStage.setScene(scene15);
                                        button36.setOnMouseClicked(e16->{
                                            Main h = new Main();
                                            try {
                                                h.start(primaryStage);
                                            }catch (Exception r20){

                                            }
                                        });
                                    }catch(Exception r16){
                                        primaryStage.setScene(scene11);
                                    }

                                
                                    button37.setOnMouseClicked(e16->{
 try
        {
       

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            Socket s = new Socket(ip, 7744);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            String massage = null;
                             massage = "9" + "," + textField25.getText() + "," + textField27.getText();
                             
           
            dos.writeUTF(massage);
            dos.flush();

               
             String   received = dis.readUTF();
            
             if(received.equals("error")){
                 System.out.println("ثبت نام مستعار با مشکل مواجه شده است.");
                 s.close();
             dis.close();
             dos.close();
                 exit();
            }
             else{
                 System.out.println("ثبت نام مسعتار با موفقیت انجام شده است.");
                 System.out.print(received);
                 s.close();
             dis.close();
             dos.close();
                 exit();
             }
 
        }catch(Exception m){
            m.printStackTrace();
            return ;
        }
                                    });
                                });
                                
                            }catch(Exception r3){
                                primaryStage.setScene(scene3);
                            }
                            
                        });
                        button5.setOnMouseClicked(e10 ->{
                             try
        {
       

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            Socket s = new Socket(ip, 7744);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            String massage = null;
                             massage = "3.1,0";
                             
           
            dos.writeUTF(massage);
            dos.flush();

               
             String   received = dis.readUTF();
            
             if(received.equals("error")){
                 System.out.println("نشان دادن حساب ها با مشکل مواجه شده است.");
                 s.close();
             dis.close();
             dos.close();
                 exit();
            }
             else{
                 System.out.println("نشان دادن حساب ها با موفقیت انجام شد");
                 System.out.print(received + "\n");
                 s.close();
             dis.close();
             dos.close();
                 exit();
             }

        }catch(Exception m){
            m.printStackTrace();
            return ;
        }
                        
                      /*      BorderPane root12 = new BorderPane();
                            TextField textField21 = new TextField();
                            textField21.setPromptText("شماره حساب");
                            textField21.setMaxWidth(200);
                            textField21.setAlignment(Pos.CENTER);
                            TextField textField20 = new TextField();
                            textField20.setPromptText("رمز حساب");
                            textField20.setAlignment(Pos.CENTER);
                            textField20.setMaxWidth(200);
                            Button button29 = new Button("بازگشت");
                            Button button30 = new Button("   ثبت   ");
                            HBox hBox19 = new HBox(10);
                            hBox19.getChildren().addAll(button29,button30);
                            hBox19.setAlignment(Pos.CENTER);
                            root12.setPadding(new Insets(10));
                            root12.setTop(textField21);
                            root12.setCenter(textField20);
                            root12.setBottom(hBox19);
                            button30.setOnMouseClicked(e13 -> {
                                String balance = "######";
                                String transfers = "\nsfdsdf\nsdfsdf\nasdsfsg\ngrerger\neew";
                                String type = "fsdf";
                                Label l8 = new Label("نوع حساب :  ");
                                Label l9 = new Label(type);
                                Label l4 = new Label("موجودی :  ");
                                Label l5 = new Label("لیست تراکنش ها :");
                                Label l6 = new Label(balance);
                                Label l7 = new Label(transfers);
                                HBox hBox17 = new HBox(50);
                                HBox hBox15 = new HBox(40);
                                HBox hBox16 = new HBox(10);
                                VBox vBox6 = new VBox(10);
                                hBox15.getChildren().addAll(l6, l4);
                                hBox16.getChildren().addAll(l7, l5);
                                hBox17.getChildren().addAll(l9, l8);
                                hBox17.setAlignment(Pos.CENTER);
                                hBox15.setAlignment(Pos.CENTER);
                                hBox16.setAlignment(Pos.TOP_CENTER);
                                vBox6.setAlignment(Pos.CENTER);
                                Button button23 = new Button("بازگشت");
                                vBox6.getChildren().addAll(hBox17, hBox15, hBox16, button23);
                                BorderPane root10 = new BorderPane();
                                l4.setAlignment(Pos.CENTER_RIGHT);
                                l5.setAlignment(Pos.CENTER_RIGHT);
                                button23.setAlignment(Pos.CENTER_RIGHT);
                                root10.setCenter(vBox6);
                                try {
                                    Scene scene9 = new Scene(root10, 240, 300);
                                    primaryStage.setScene(scene9);
                                } catch (Exception r7) {
                                    primaryStage.setScene(scene3);
                                }
                            });
                            
                            try {
                                Scene scene10 = new Scene(root12,220,100);
                                primaryStage.setScene(scene10);
                            }catch(Exception r7){
                                primaryStage.setScene(scene3);
                            }
                            if(false) {

                            }
                            */
                        });
                        button4.setOnMouseClicked(e9 ->{
                            Button button21 = new Button("بازگشت");
                            Button button22 = new Button("ایجاد حساب");
                            button21.setMinWidth(90);
                            button22.setMinWidth(90);
                            Pane root9 = new Pane();
                            Label l2 = new Label("نوع حساب");
                            Label l3 = new Label("رمز");
                            TextField textField19 = new TextField();
                            textField19.setMaxWidth(200);
                            textField19.setPromptText("رمز حساب");
                            textField19.setAlignment(Pos.CENTER);
                            // string array
                            String st1[] = { "کوتاه مدت", "بلند مدت" };

                            // create a choiceBox
                            ChoiceBox c1 = new ChoiceBox(FXCollections.observableArrayList(st1));

                            // add a listener
                            /*c.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

                                // if the item of the list is changed
                                public void changed(ObservableValue ov, Number value, Number new_value)
                                {

                                    // set the text for the label to the selected item
                                    l1.setText(st[new_value.intValue()] + " selected");
                                }
                            });*/

                            // add ChoiceBox
                            HBox hBox12 = new HBox(50);
                            hBox12.getChildren().addAll(c1,l2);
                            HBox hBox13 = new HBox(20);
                            hBox13.getChildren().addAll(textField19,l3);
                            HBox hBox14 = new HBox(10);
                            hBox14.getChildren().addAll(button21,button22);
                            VBox vBox5 = new VBox(10);
                            vBox5.getChildren().addAll(hBox12,hBox13,hBox14);
                            vBox5.setAlignment(Pos.CENTER);
                            root9.getChildren().add(vBox5);
                            vBox5.setPadding(new Insets(20));
                            root9.setPadding(new Insets(20));
                            button22.setOnMouseClicked(e12 ->{
                                try
        {
       

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            Socket s = new Socket(ip, 7744);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            String massage = null;
                            String kind;
                            if(c1.getValue().equals("کوتاه مدت"))
                                kind = "SHORT";
                            else
                                kind = "LONG";
                             massage = 2 + "," + kind + "," +textField19.getText() ;
                             
           
            dos.writeUTF(massage);
            dos.flush();

               
             String   received = dis.readUTF();
            
             if(received.equals("error")){
                 System.out.println("باز کردن حساب با مشکل مواجه شده است.");
                 s.close();
             dis.close();
             dos.close();
                 exit();
            }
             else{
                 System.out.println("حساب با موفقیت باز شد.");
                 s.close();
             dis.close();
             dos.close();
                 exit();
             }
 
        }catch(Exception m){
            m.printStackTrace();
            return ;
        }
                            });
                            try {
                                Scene scene8 = new Scene(root9,240,130);
                                primaryStage.setScene(scene8);
                            }catch(Exception r7){
                                primaryStage.setScene(scene3);
                            }
                        });
                });
                }
                //age ramz ro eshtebah zad
                if(false) {
                    button3.setOnMouseClicked(e2 -> {
                        textField.setStyle("-fx-text-fill: red;");
                        textField2.setStyle("-fx-text-fill: red;");
                    });
                }
            } catch (Exception r2) {
                primaryStage.setScene(scene);
            }


        primaryStage.show();
        });
        button2.setOnMouseClicked(e ->{
            Label label = new Label("ثبت نام موفق بود");
            Label label1 = new Label("ثبت نام موفق بود");
            VBox vbox = new VBox(10);
            Button button3 = new Button("     ثبت    ");
            Button button24 = new Button("بازگشت");
            TextField textField = new TextField();
            textField.setMaxWidth(250);
            textField.setPromptText("نام");
            TextField textField2 = new TextField();
            textField2.setMaxWidth(250);
            textField2.setPromptText("نام خانوادگی");
            TextField textField3 = new TextField();
            textField3.setMaxWidth(250);
            textField3.setPromptText("کد ملی");
            TextField textField4 = new TextField();
            textField4.setPrefWidth(250);
            textField4.setPromptText("رمز عبور");
            TextField textField5 = new TextField();
            textField5.setMaxWidth(250);
            textField5.setPromptText("شماره تلفن");
            TextField textField6 = new TextField();
            textField6.setMaxWidth(250);
            textField6.setPromptText("ایمیل");
            textField.setAlignment(Pos.CENTER);
            textField2.setAlignment(Pos.CENTER);
            textField3.setAlignment(Pos.CENTER);
            textField4.setAlignment(Pos.CENTER);
            textField5.setAlignment(Pos.CENTER);
            textField6.setAlignment(Pos.CENTER);
            HBox hBox18 = new HBox(10);
            hBox18.getChildren().addAll(button24,button3);
            hBox18.setAlignment(Pos.CENTER);
            vbox.getChildren().addAll(textField,textField2,textField3,textField4,
                    textField5,textField6,hBox18);
            vbox.setPadding(new Insets(10,0,0,50));
            vbox.setAlignment(Pos.CENTER);
            root3.getChildren().add(vbox);
            try {
                Scene scene2 = new Scene(root3, 350, 250);
                primaryStage.setScene(scene2);
                button3.setOnMouseClicked(e1 ->{
                    try
        {
       

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            Socket s = new Socket(ip, 7744);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            String massage = null;
                             massage = 0 + "," + textField.getText() + " " +textField2.getText() + "," + textField3.getText() + "," + textField4.getText() + "," + textField5.getText() + "," + textField6.getText();
                             
           
            dos.writeUTF(massage);
            dos.flush();

               
             String   received = dis.readUTF();
            
             if(received.equals("error")){
                 System.out.println("ثبت نام با مشکل مواجه شده است.");
                 s.close();
             dis.close();
             dos.close();
                 exit();
            }
             else{
                 System.out.println("ثبت نام با موفقیت انجام شد.");
                 s.close();
             dis.close();
             dos.close();
                 exit();
             }
 
        }catch(Exception m){
            m.printStackTrace();
            return ;
        }
                    if(true){
                        Main h = new Main();
                        try {
                            h.start(primaryStage);
                        }catch (Exception r6){

                        }
                    }
                    if(false){

                    }

                    for(long i =0 ; i<=999999999L;i++){

                    }
                });
                button24.setOnMouseClicked(e11 ->{
                    Main h = new Main();
                    try {
                        h.start(primaryStage);
                    }catch (Exception r7){

                    }
                });
            }catch (Exception r){
                primaryStage.setScene(scene);
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}