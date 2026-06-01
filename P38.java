//================================================================================//
//Блок finally
//================================================================================//
/*
public class P38 {

    public static void main(String[] args) {

        // практика 1
        //использовать try без catch
        //и finally нельзя
        //такой код не скомпилируется
        //try {
        //    int a = 10;
        //}

        // практика 2
        //try только с finally
        //использовать можно

        try {
            int a = 10 / 2;
            System.out.println(a);
        } finally {
            System.out.println(
                    "finally выполнится всегда"
            );
        }
        */
/*
        // практика 3
        //два finally использовать нельзя
        //такой код не скомпилируется
        try {
            int a = 10;
        } finally {
            System.out.println(1);
        } finally {
            System.out.println(2);
        }

    }
}
