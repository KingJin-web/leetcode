create table A
(
    ACCT_MONTH       varchar(6) not null comment '������',
    USER_NO          int(15)    not null comment '�û�����',
    TELE_TYPE        varchar(6) comment 'ҵ������',
    TOTAL_CHARGE     int comment '�ϼ�',
    CALL_FEE         int comment 'ͨ����',
    RENT_FEE         int comment '�����',
    MOBILE_FEE       int comment '�����ƶ���',
    LONG_FEE         int comment '������',
    INTLONG_FEE      int comment '���ʳ�;��',
    ROAM_FEE         int comment '���η�',
    ROAM_INTLONG_FEE int comment '���ι��ʳ�;��',
    ROAM_LONG_FEE    int comment '���ι��ڳ�;��',
    DATA_FEE         int comment '���ݷ�',
    INCREMENT_FEE    int comment '��ֵҵ���',
    SMS_FEE          int comment '���ŷ�',
    SPECIAL_FEE      int comment '�ط���',
    MON_FEE          int comment '���·�',
    OTHER_FEE        int comment '������',
    SP_FEE           int comment 'SP��',
    CONSENT_FEE      int comment '��ŵ��'
);

create table B
(
    ACCT_MONTH    varchar(6) not null comment '������',
    USER_NO       int(15)    not null comment '�û�����',
    TOTAL_CHARGE  int comment '�ܷ���',
    TELE_TYPE     varchar(6) comment 'ҵ������',
    CDR_NUM       int comment '������',
    CALL_DURATION int comment 'ͨ��ʱ��',
    IS_ZERO_CALL  char(1) comment '�Ƿ���ͨ����־'

);

2.	����
?	�����û�
ÿ��ĩ����ʱ���������õ��û���

?	δ�����û�
ÿ��ĩ����ʱ��δ�������õ��û��������û������ڱ��г��֡�

?	��ͨ��
�û��ڵ���δ��������ͨ����

?	����ͨ��
�û��ڵ���������ͨ����

?	���������û�
�û��ڵ����ǳ����û������Ƿ���ͨ����

?	�����������û�
�û��ڵ�����δ�����û��������û��ڵ����ǳ����û�������ͨ����

?	��ʧ�û�
�û������������������û������ڵ����Ƿ����������û���

