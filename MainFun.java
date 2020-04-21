import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainFun {
    public static void main(String[] args) throws IOException {

        int i, j, DlinaSlova; char chr;


        String StringKodSimvol, Slovo, BinarMessToString, StrokaOnFile;
        Scanner name = new Scanner(System.in);  Scanner in = new Scanner(System.in); Scanner method = new Scanner(System.in);


        System.out.print("Введите 0, если нужно зашифровать, либо 1, если нужно дешифровать слово: ");
        int num = in.nextInt();
        if (num != 0 & num !=1) {
            System.out.print("Вы должны ввести либо 0, либо 1");
            System.exit(0);
        }
        System.out.print("Введите номер метода: ");
        int numMethod = method.nextInt();

        StringBuffer BinarKodSimvol = new StringBuffer("");
        HashMap<Character, String> hashmap = new HashMap<>();

            for (i = 1040; i < 1104; i++) {
            j = i - 1040;
            StringKodSimvol = Integer.toBinaryString(j);
            BinarKodSimvol.insert(0, StringKodSimvol);
            while (BinarKodSimvol.length() != 6) BinarKodSimvol.insert(0, '0');
            chr = (char) i;
            hashmap.put(chr, BinarKodSimvol.toString());
            BinarKodSimvol.setLength(0);

        }

switch (numMethod) {
    case (1):
///
    if (num == 0) {
        System.out.print("Введите слово: ");
        Scanner scan = new Scanner(System.in);
        Slovo = scan.next();
        DlinaSlova = Slovo.length();
        char[] chars = Slovo.toCharArray();

        BufferedReader br = null;
        StringBuffer stroka = new StringBuffer("");
        StringBuffer BinarMess = new StringBuffer("");
        System.out.print("Введите имя файла для чтения: ");
        String inputFileName = name.nextLine();
        br = new BufferedReader(new FileReader(inputFileName));
        for (i = 0; i < DlinaSlova; i++) {
            BinarMess.insert(i * 6, hashmap.get(chars[i]));
        }

        BinarMessToString = BinarMess.toString();
        char[] charl = BinarMessToString.toCharArray();

        int k = 0;
        System.out.print("Введите имя файла для записи: ");
        String outPut = name.nextLine();
        FileWriter nFile = new FileWriter(outPut);
        String line;
        try {

            while ((line = br.readLine()) != null) {
                stroka.insert(0, line);
                if (k < BinarMessToString.length()) {
                    for (int index = 0; index < stroka.length(); index++) {
                        if (k == (BinarMessToString.length())) break;
                        if (stroka.charAt(index) == 'а' & charl[k] == '0') {
                            stroka.setCharAt(index, 'a');
                            k++;
                        }
                        if (k == (BinarMessToString.length())) break;
                        if (stroka.charAt(index) == 'е' & charl[k] == '1') {
                            stroka.setCharAt(index, 'e');
                            k++;

                        }

                    }
                }
                StrokaOnFile = stroka.toString();
                nFile.write(StrokaOnFile);
                nFile.write('\n');
                stroka.setLength(0);
            }
        } catch (IOException e) {
            System.out.println("Error" + e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Error" + e);
            }

        }
        System.out.println("Операция успешно произведена.");
        nFile.close();
    } else {
        System.out.print("Введите имя файла для чтения: ");
        String outPut = name.nextLine();
        BufferedReader bro = null;
        bro = new BufferedReader(new FileReader(outPut));

        try {

            int k = 0;
            StringBuffer linE = new StringBuffer("");
            StringBuffer kods = new StringBuffer("");
            String line2;
            while ((line2 = bro.readLine()) != null) {
                linE.insert(0, line2);
                for (int index = 0; index < linE.length(); index++) {
                    if (linE.charAt(index) == 'a') {
                        kods.insert(k, '0');
                        k++;
                    }
                    if (linE.charAt(index) == 'e') {
                        kods.insert(k, '1');
                        k++;
                    }

                }
                linE.setLength(0);
            }
            String ops = kods.toString();
            char[] chark = ops.toCharArray();
            char lol[] = new char[6];

            i = 0;
            j = 0;
            int u = 0;
            String p;
            StringBuffer lp = new StringBuffer("");
            while (i < kods.length()) {
                lol[j] = chark[i];
                j++;
                if (j == 6) {
                    p = new String(lol);
                    lp.insert(u, getKeyFromValue(hashmap, p));
                    j = 0;
                    u++;
                }
                i++;
            }
            System.out.print("Зашифровано слово: ");
            System.out.print(lp);
        } catch (
                IOException e) {
            System.out.println("Error" + e);
        } finally {
            try {
                bro.close();
            } catch (IOException e) {
                System.out.println("Error" + e);
            }
        }
    }

break;
    case (2):

        if (num == 0) {
        System.out.print("Введите слово: ");
        Scanner scan = new Scanner(System.in);
        Slovo = scan.next();
        DlinaSlova = Slovo.length();
        char[] chars = Slovo.toCharArray();

        BufferedReader br = null;
        StringBuffer stroka = new StringBuffer("");
        StringBuffer BinarMess = new StringBuffer("");
        System.out.print("Введите имя файла для чтения: ");
        String inputFileName = name.nextLine();
        br = new BufferedReader(new FileReader(inputFileName));
        for (i = 0; i < DlinaSlova; i++) {
            BinarMess.insert(i * 6, hashmap.get(chars[i]));
        }

        BinarMessToString = BinarMess.toString();
        char[] charl = BinarMessToString.toCharArray();

        int k = 0;
        System.out.print("Введите имя файла для записи: ");
        String outPut = name.nextLine();
        FileWriter nFile = new FileWriter(outPut);
        String line;

            try {
                while ((line = br.readLine()) != null) {
                    stroka.insert(0, line);
                    StrokaOnFile = stroka.toString();
                    nFile.write(StrokaOnFile);

                    if (k < BinarMessToString.length()) {
                        if (charl[k] == '1') {
                            nFile.write(' ');
                        }

                    }

                    if (k == BinarMessToString.length()) {
                        nFile.write("  ");
                    }
                    k++;

                    nFile.write('\n');
                    stroka.setLength(0);
                }
            } catch (IOException e) {
                System.out.println("Error" + e);
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error" + e);
                }

            }
            System.out.println("Операция успешно произведена.");
            nFile.close();
        } else {
            System.out.print("Введите имя файла для чтения: ");
            String outPut = name.nextLine();
            BufferedReader bro = null;
            bro = new BufferedReader(new FileReader(outPut));

            try {

                int k = 0;
                StringBuffer linE = new StringBuffer("");
                StringBuffer kods = new StringBuffer("");
                String line2;
                while ((line2 = bro.readLine()) != null) {
                    linE.insert(0, line2);
                    if (line2.length() != 0) {
                        if (linE.charAt(line2.length()-1) == ' ')  {
                            if (line2.length() > 1) {
                            if (linE.charAt(line2.length()-2) == ' ') break; }
                            kods.insert(k, '1');
                            k++;
                        } else {
                            kods.insert(k, '0');
                            k++;
                        }
                    } else {
                        kods.insert(k, '0');
                        k++;
                    }



                    linE.setLength(0);
                }
                String ops = kods.toString();
                char[] chark = ops.toCharArray();
                char lol[] = new char[6];

                i = 0;
                j = 0;
                int u = 0;
                String p;
                StringBuffer lp = new StringBuffer("");
                while (i < kods.length()) {
                    lol[j] = chark[i];
                    j++;
                    if (j == 6) {
                        p = new String(lol);
                        lp.insert(u, getKeyFromValue(hashmap, p));
                        j = 0;
                        u++;
                    }
                    i++;
                }
                System.out.print("Зашифровано слово: ");
                System.out.print(lp);
            } catch (
                    IOException e) {
                System.out.println("Error" + e);
            } finally {
                try {
                    bro.close();
                } catch (IOException e) {
                    System.out.println("Error" + e);
                }
            }
        }



        break;
    case (3):
        if (num == 0) {
            System.out.print("Введите слово: ");
            Scanner scan = new Scanner(System.in);
            Slovo = scan.next();
            DlinaSlova = Slovo.length();
            char[] chars = Slovo.toCharArray();

            BufferedReader br = null;
            StringBuffer stroka = new StringBuffer("");
            StringBuffer BinarMess = new StringBuffer("");
            System.out.print("Введите имя файла для чтения: ");
            String inputFileName = name.nextLine();
            br = new BufferedReader(new FileReader(inputFileName));
            for (i = 0; i < DlinaSlova; i++) {
                BinarMess.insert(i * 6, hashmap.get(chars[i]));
            }

            BinarMessToString = BinarMess.toString();
            char[] charl = BinarMessToString.toCharArray();

            int k = 0;
            System.out.print("Введите имя файла для записи: ");
            String outPut = name.nextLine();
            FileWriter nFile = new FileWriter(outPut);
            String line;
            try {

                while ((line = br.readLine()) != null) {
                    stroka.insert(0, line);
                    if (k < BinarMessToString.length()) {
                        for (int index = 0; index < stroka.length(); index++) {
                            if (k == (BinarMessToString.length())) break;
                            if (stroka.charAt(index) == ' ' & charl[k] == '0') {
                                stroka.setCharAt(index, ' ');
                                k++;
                            }
                            if (k == (BinarMessToString.length())) break;
                            if (stroka.charAt(index) == ':' & charl[k] == '1') {
                                stroka.setCharAt(index, '։');
                                k++;

                            }

                        }
                    }
                    StrokaOnFile = stroka.toString();
                    nFile.write(StrokaOnFile);
                    nFile.write('\n');
                    stroka.setLength(0);
                }
            } catch (IOException e) {
                System.out.println("Error" + e);
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error" + e);
                }

            }
            System.out.println("Операция успешно произведена.");
            nFile.close();
        } else {
            System.out.print("Введите имя файла для чтения: ");
            String outPut = name.nextLine();
            BufferedReader bro = null;
            bro = new BufferedReader(new FileReader(outPut));

            try {

                int k = 0;
                StringBuffer linE = new StringBuffer("");
                StringBuffer kods = new StringBuffer("");
                String line2;
                while ((line2 = bro.readLine()) != null) {
                    linE.insert(0, line2);
                    for (int index = 0; index < linE.length(); index++) {
                        if (linE.charAt(index) == ' ') {
                            kods.insert(k, '0');
                            k++;
                        }
                        if (linE.charAt(index) == '։') {
                            kods.insert(k, '1');
                            k++;
                        }

                    }
                    linE.setLength(0);
                }
                String ops = kods.toString();
                char[] chark = ops.toCharArray();
                char lol[] = new char[6];

                i = 0;
                j = 0;
                int u = 0;
                String p;
                StringBuffer lp = new StringBuffer("");
                while (i < kods.length()) {
                    lol[j] = chark[i];
                    j++;
                    if (j == 6) {
                        p = new String(lol);
                        lp.insert(u, getKeyFromValue(hashmap, p));
                        j = 0;
                        u++;
                    }
                    i++;
                }
                System.out.print("Зашифровано слово: ");
                System.out.print(lp);
            } catch (
                    IOException e) {
                System.out.println("Error" + e);
            } finally {
                try {
                    bro.close();
                } catch (IOException e) {
                    System.out.println("Error" + e);
                }
            }
        }


        break;
}

    }
    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }
}
