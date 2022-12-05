package Entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BlockMoviesFiles {

    private String File;

    public BlockMoviesFiles(String accountRegistry) {
        this.File = accountRegistry;
    }

    public BlockMoviesFiles() {
        this("Registro_De_Contas.txt");
    }

    public void saveAccount(List<BlockAccount> accountList) throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.File))) {
            for (BlockAccount acc : accountList) {
                String accInfo = acc.getLogin() + "//" + acc.getPassword() + "//" + acc.getTwoFA();
                bw.write(accInfo + "\n-----------------------------");
            }
        }
    }

    public List<BlockAccount> readAccData() throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(this.File))){
            List<BlockAccount> accList = new ArrayList<>();
            String accInfo;
            accInfo = br.readLine();

            while (accInfo != null) {
                accInfo = br.readLine();

                if (accInfo != null) {
                    String[] accData = accInfo.split("//");
                    BlockAccount acc = new BlockAccount(accData[0], accData[1], accData[2]);
                    accList.add(acc);
                }
            }
            return accList;
        }
    }
}