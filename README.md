BOX��Ŀ�ṹ����
===================
----------
#package introduce
1.des��3des�㷨�������õ�<br>
2.device������<br>
3.html������html��������ͷ���⣬Ŀǰ��δʵ��<br>
4.md5��md5<br>
5.photo������΢���ϴ�ͼƬ������<br>
6.rsa:rsa�����õ�<br>
7.util:���ù�����<br>
8.phototwo:�����֤�ս�ͼ<br>
9.AIDL<br>
10.��ͬ�����Ĵ������<br>
#assets


#so


#jar

#module
1.cameracropper:�Զ������ս��棬ʵ������������Զ������<br>
�÷���<br>
/*
*��ת����
*/
 private void intentPhotoAct(){
        intentPhoto=new Intent(mContext,TakePhoteActivity.class);
        startActivityForResult(intentPhoto,requestCodePhoto);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        MyLogger.aLog().i("requestCode=" + requestCode);
        MyLogger.aLog().i("resultCode=" + resultCode);
        if(resultCode==RESULT_OK){

            switch (requestCode) {
                case requestCodePhoto://���ճɹ�
                   selectPhotoPahtResult(data.getData(),data.getStringExtra("path"));
                    break;

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

   private void selectPhotoPahtResult(Uri uri,String filepath){
       switch (index) {
           case R.id.iv_acc_err1://
               fileSFZZMPath = filepath;
               ivewSFZZM.setImageURI(uri);
               ivewSFZZM_pz.setImageResource(R.mipmap.photo2);
               break;


       }
   }
