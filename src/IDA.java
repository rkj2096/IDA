/**
 * @(#)IDA.java
 *
 *
 * @author
 * @version 1.00 2015/11/1
 */

public class IDA {
    private int n,m,p;

    public IDA(int n,int m,int p) {
    	this.n=n;
    	this.m=m;
    	this.p=p;
    }
    public double[][] encode(double message[]){
    	int l=message.length;
    	double a[][]=new double[n][m];
    	double c[][]=new double[n][l/m];
    	for(int i=0;i<n;++i){
    		for(int j=0;j<m;++j){
    			a[i][j]=Math.pow(1+i,j);
    		}
    	}
    	for(int i=0;i<n;++i){
    		for(int j=0;j<l/m;++j){
    			for(int k=0;k<m;++k){
    				c[i][j]+=a[i][k]*message[j*m+k];
    			}
    		}
    	}
      return c;
    }
    public double[] decode(double message[][],int []fid){
    	int l=message.length*message[0].length;
    	double a[][]=new double[m][m];
    	double ia[][]=new double[m][m];
    	double dm[]=new double[l];
    	for(int i=0;i<m;++i){
    		for(int j=0;j<m;++j){
    			a[i][j]=Math.pow(fid[i],j);
    		}
    	}
        Inverse in=new Inverse();
    	ia=in.invert(a);
       for(int i=0;i<l;++i){
       	 	for(int k=0;k<m;++k){
       	 		dm[i]+=ia[i%m][k]*message[k][i/m];
       	 	}
       }
       return dm;
    }
    public String sencode(String st){
    	String en="";
    	String mess[]=st.split(" ");
    	int l=mess.length;
    	double message[]= new double[l];
    	for(int i=0;i<l;++i){
    	 message[i]=Double.parseDouble(mess[i]);
    	}
    	double em[][]=encode(message);
    	for(int i=0;i<n;++i){
    		en+=(i+1)+":";
    		for(int j=0;j<l/m;++j){
    		en+=em[i][j]+" ";
    		}
    	 	en+="\n";
    	}
     return en;
    }
    public String sdecode(String ms){
    	String rme="";
    	String sms[]=ms.split("\n");
    	int sl=sms.length;
    	String id[]=new String[sl];
    	for(int i=0;i<sl;++i){
    		String tm[]=sms[i].split(":");
    		id[i]=tm[0];
    		sms[i]=tm[1];
    	}
    	String fl[]=sms[0].split(" ");
    	int f=fl.length;
    	String smess[][]=new String[sl][f];
    	int fid[]=new int[sl];
    	double mess[][]=new double[sl][f];

    	for(int i=0;i<sl;++i){
    	   	smess[i]=sms[i].split(" ");
    	}

    	for(int i=0;i<sl;++i){
    		fid[i]=Integer.parseInt(id[i]);
    	}
    	for(int i=0;i<sl;++i){
    		for(int j=0;j<f;++j){
    			mess[i][j]=Double.parseDouble(smess[i][j]);
    		}
    	}
    	double []rm=decode(mess,fid);
    	for(int i=0;i<rm.length;++i){
    		rme+=Math.round(rm[i])+" ";
    	}
     return rme;
    }

   public static void main(String[] args) {
      IDA ida=new IDA(14,10,40);
      double message[] ={12,23,34,5,3,4,2,4,23,21,12,13,9,12,19,17,27,6,23,26,12,23,34,5,3,4,2,4,23,21,12,13,9,12,19,17,27,6,23,26};
      double em[][]=new double[14][4];
      em=ida.encode(message);
    	for(int i=0;i<ida.n;++i){
    		System.out.print("Slice-"+(i+1)+":");
    		for(int j=0;j<ida.p/ida.m;++j){
    		System.out.print(em[i][j]+" ");
    		}
    	 	System.out.println();
    	}


    String mess="1:131.0 164.0 131.0 164.0"+"\n"+
"2:17690.0 22714.0 17690.0 22714.0"+"\n"+
"3:576189.0 701592.0 576189.0 701592.0"+"\n"+
"4:7091912.0 8555216.0 7091912.0 8555216.0"+"\n"+
"10:2.3342438642E10 2.8388903042E10 2.3342438642E10 2.8388903042E10"+"\n"+
"6:2.51513286E8 3.03750414E8 2.51513286E8 3.03750414E8"+"\n"+
"7:9.83623625E8 1.190237984E9 9.83623625E8 1.190237984E9"+"\n"+
"8:3.213509444E9 3.895839412E9 3.213509444E9 3.895839412E9"+"\n"+
"9:9.146362107E9 1.1107192116E10 9.146362107E9 1.1107192116E10"+"\n"+
"14:4.68264131102E11 5.71976050966E11 4.68264131102E11 5.71976050966E11";
     System.out.println(ida.sdecode(mess));
    }
}
