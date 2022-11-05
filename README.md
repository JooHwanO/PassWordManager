# PassWord Manager
비밀번호 관리 프로그램 

---

## 1. 프로젝트 개요 
PC방에서 친구들과 게임을 하면서 여러 사이트의 비밀번호를 관리하기 어려운 점에 착안하여 해당 개발을 진행하게 되었다.<br>
<p>프로그램 실행 시 가입된 각 사이트의 비밀번호가 변경된 시간을 표시하며 비밀번호 관리에서 입력,수정,삭제가 가능하도록 하여 사용자가 관리하도록 계획하였다.</p>
<p>친구들에게 만든 프로그램을 배포하여 사용할 수 있도록 서버 컴퓨터를 지정하여 연결하도록 한다.</p>

---

## 2. 개발 환경
| 도구 | 설명 |
| ------------ | ------------- |
| IDE | 이클립스  2020 -  0 3 Version |
| JDK |  JDK 1.8.0_281 |
| DB | Database 11g Express Edition |
| DB - IDE | SQL-DEVELOPER |
| 기타 | JDBC6, JCalender |

---

## 3. 실행 화면
### 3.1 아이콘

![image](https://user-images.githubusercontent.com/110041859/199970028-a5de2513-c05e-401b-ba49-c4aa78e3a460.png) 자물쇠모양으로 표현 하였음.

### 3.2 로그인 화면
![image](https://user-images.githubusercontent.com/110041859/200115141-d26ce691-23ca-4b97-8710-2a41938e4287.png)

---

### 3.3 회원가입 화면 

![image](https://user-images.githubusercontent.com/110041859/200115421-07f20ff1-a449-456a-9bd6-a3533e131c59.png)

<br>

![image](https://user-images.githubusercontent.com/110041859/200115457-5f9ea0f9-b450-4986-b192-9a63b6a7c2af.png)

<br>

![image](https://user-images.githubusercontent.com/110041859/200115490-3662dbc0-8558-4659-8cb4-972db4006733.png)

---

### 3.4 메인 화면

![image](https://user-images.githubusercontent.com/110041859/200115514-6d67a360-d888-41d4-bf9c-36c8f7934f93.png)

---

### 3.5 정보 입력 

![image](https://user-images.githubusercontent.com/110041859/200115643-4654dcab-36e2-48ae-be03-2ebbf8932ab4.png)

---

### 3.6 정보 변경

![image](https://user-images.githubusercontent.com/110041859/200115675-ba961e52-d4e9-4f7c-b6d1-0dbb3fa28073.png)

---

### 3.7 정보 삭제

![image](https://user-images.githubusercontent.com/110041859/200115689-0c309526-b7c0-4249-8691-b6397f0b6613.png)

---

### 3.8 전체 정보 확인 

![image](https://user-images.githubusercontent.com/110041859/200115948-27f2e7dc-e7c9-4054-9d0e-199888b7188c.png)

<br>
각 분류 별로 정보를 확인할 수 있음
<br>

![image](https://user-images.githubusercontent.com/110041859/200115955-2f12f7b3-d80d-44d8-b816-fe0f0ab5d227.png)

### 3.9 비밀번호 경과 확인 화면 

![image](https://user-images.githubusercontent.com/110041859/200116090-81f289ae-8bb6-434f-b58f-19bc411c219a.png)

## 4. 외부 접속 설정 및 포트포워딩 
> 프로그램을 만든 후 친구들에게 배포하였을 때 외부에서 접속하지 못하는 현상이 일어났다..<br> 이를 해결하기 위해 외부 IP 주소를 확인하고 외부와 연결 시킨 뒤 해당 컴퓨터 내부 IP로 들어오도록 내부 IP를 고정시켰다..<br> 

### 4.1 네트워크 설정

![image](https://user-images.githubusercontent.com/110041859/200116305-2776a996-3e4e-4db4-bc50-ee5f64cf6dcb.png)

---

#### 🎈 공인 IP 설명 

![image](https://user-images.githubusercontent.com/110041859/200116315-80b2b6ca-2b29-40c7-adad-774cb392692a.png)

---

#### 🎈 사설 IP 설명

![image](https://user-images.githubusercontent.com/110041859/200116328-322d10c7-c957-469d-98fa-950c20e1fae1.png)

---

#### 🎈 고정 IP 설정

![image](https://user-images.githubusercontent.com/110041859/200116339-512246c6-e669-4afe-9495-0741ba08b0eb.png)

---

#### 🎈 포트 번호로 서버 PC 들어오기

![image](https://user-images.githubusercontent.com/110041859/200116486-c466c5af-8b8d-40b0-8d6f-f13be49b4849.png)

---

#### 🎈 방화벽 해제

![image](https://user-images.githubusercontent.com/110041859/200116510-37e857fe-f6cf-467d-8f45-3d71cb51bb4f.png)

<br>
<br>

![image](https://user-images.githubusercontent.com/110041859/200116523-902691ac-8b6c-40c4-8fe7-b66bef0c86a8.png)

---

#### 🎈 포트 포워딩

![image](https://user-images.githubusercontent.com/110041859/200116558-77c5d0ed-75d7-40d5-bf3b-723242a4e6ad.png)

---


## 4.2 개념 정리
🧨 사설 IP :<br> - 외부에서 내 컴퓨터를 찾을 수 없음 <br> - 사설 IP는 세계적으로 중복된 IP를 서로 사용중임.(192.168.0.1) <br> - 따라서 사설 IP는 내부(집)에서만 의미가 있고 외부에서는 해당 IP로 접속이 불가함 <br>

🧨 사설 IP로 서버 운영 방법  : <br> - 포트포워딩을 사용함. <br> - 회사에서 부여받은 공인 IP를 219.214.22.123 이라 가정한다 <br> - 내부에서 사설 IP를 192.168.0.3을 사용함.
<br - 이때 공유기가 219.214.22.123의 80번 포트로 들어오는 패킷 사설 IP로 전달한다 <br> -이렇게 하면 특정 포트로 들어오는 패킷을 사설IP로 보내 192.168.0.3 컴퓨터를 웹 서버 컴퓨터로 사용할 수 있다. 

---

## 5. 후기 보안 
 
비밀번호 관리를 목적으로 만들었지만 정작 해당 프로그램에 접속할 마스터 비밀번호에 대한 보안을 생각하지 않았던 것 같다.
그저 만들기에만 급급했던게 아닌가하는 후회가 든다. 또한 해당 프로그램에 대한 관리에대해서도 생각하지 않았다.
수업시간에 잠시 배운 SW 품질에 대하여 좀 더 공부하고 보완한다면 괜찮은 프로그램이 되지 않을까?...
그리고 포트포워딩에 대한 개념을 배웠으며 제대로 된 배포는 아니지만 지인들에게 배포하여 실제로 동작하는지 보는것에 뿌듯함을 느꼇던 프로젝트였다.

