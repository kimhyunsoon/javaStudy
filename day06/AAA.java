class AAA{
    String strs[]; //����
    AAA(){
        strs = new String[4]; //���� ũ�Ⱑ 4���� �迭 ����
    }
    void input(){//�ʱ�ȭ
        strs[0] = "ġŲ";
        strs[1] = "����";
        strs[2] = "������";
        strs[3] = "�߹�";
    }

    void output(){//���� �� ������ ���
        System.out.println("strs[0]: "+strs[0]);
        System.out.println("strs[1]: "+strs[1]);
        System.out.println("strs[2]: "+strs[2]);
        System.out.println("strs[3]: "+strs[3]);

    }

    void out1(){ //for������ ��������
        for(int i=0;i<strs.length;i++){ //strs.length strs�迭�� ���̰� 4
            System.out.println("strs["+i+"]: "+strs[i]);
        }
    }

    public static void main(String[] args){
        AAA a = new AAA();
        a.input();
        a.out1();
    }  










}