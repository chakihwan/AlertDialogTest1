package kr.ac.kopo.alertdialogtest1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn1 = findViewById(R.id.btn1);
        ImageView imgFood = findViewById(R.id.imgFood);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] foodItems = {"떡볶이", "무침만두", "순대"};
                final int[] imgRes = {R.drawable.ddok,R.drawable.muchimmandu,R.drawable.sundae};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("인공지능소프트웨어과 공지사항");

                dlg.setSingleChoiceItems(foodItems,0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btn1.setText(foodItems[which]);
                        imgFood.setImageResource(imgRes[which]);

//                dlg.setItems(foodItems, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        btn1.setText(foodItems[which]);
//                        imgFood.setImageResource(imgRes[which]);
//                        switch (which){
//                            case 0:
//                                imgFood.setImageResource(R.drawable.ddok);
//                                break;
//                            case 1:
//                                imgFood.setImageResource(R.drawable.muchimmandu);
//                                break;
//                            case 2:
//                                imgFood.setImageResource(R.drawable.sundae);
//                                break;
//                        }
                    }
                });
//                dlg.setMessage("우리과 학생이 사용해야 한다고 친절하게 양해를 구하면 됩니다.");
                dlg.setIcon(R.drawable.guineapig);
                dlg.setPositiveButton("닫기", null);
//                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "취소버튼이 선택되었습니다.", Toast.LENGTH_SHORT).show();
//                    }
//                });
                dlg.show();
            }
        });
    }
}