<%--
  Created by IntelliJ IDEA.
  User: TD-PC
  Date: 6/19/2020
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="ForHomePage.css">

    <title>GamingBaku</title>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script>
</head>
<body style="padding-bottom: 484px; background-attachment: fixed" class="background">

<header>
    <nav class="navigation-bar">
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a href="HomePage.jsp">
                    <img src="LOGO.png" rel="HomePage.jsp" alt="LOGO GAMINGBAKU" style="height: 50px">
                </a>
            </li>
            <li class="nav-item">
                <a href="HomePage.jsp">
                    <p class="GAMINGBAKU">GAMINGBAKU</p>
                </a>
            </li>
            <li class="nav-item">
                <div class="dropdown" style="padding: 6px 20px 0px 20px">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ƏSAS SƏHİFƏ
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#">Oyunlar</a>
                        <a class="dropdown-item" href="#">Filmlər</a>
                        <a class="dropdown-item" href="#">Texnologiya</a>
                    </div>
                </div>
            </li>
            <li class="nav-item dropdown" style="padding: 6px 20px 0px 0px">
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        XƏBƏRLƏR
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <div class="dropdown" style="padding: 6px 20px 0px 0px">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton3"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ELANLAR
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </div>
            </li>
            <li>
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Hey, burada axtar..." aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Axtar</button>
                </form>
            </li>
            <li>
                <img src="https://i.pinimg.com/originals/41/28/2b/41282b58cf85ddaf5d28df96ed91de98.png" alt="FACEBOOK"
                     style="height: 50px; margin-left: 7px; margin-top: 5px; height: 40px;">
            </li>
            <li>
                <img src="https://cdn.icon-icons.com/icons2/1584/PNG/512/3721679-youtube_108064.png" alt="YOUTUBE"
                     style="height: 50px; margin-left: 5px; margin-top: 5px; height: 40px;">
            </li>
            <li>
                <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/58/Instagram-Icon.png/1200px-Instagram-Icon.png"
                     alt="INSTAGRAM" style="height: 50px; margin-left: 10px; margin-top: 10px; height: 30px;">
            </li>
            <li>
                <div style="padding: 6px 0px 0px 20px">
                    <button type="button" class="btn btn-outline-primary">GİRİŞ</button>
                </div>
            </li>
        </ul>
    </nav>
</header>

<div class="content row">
    <div class="col-7" style="float: left; margin-left: 50px">
        <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="343434.png" class="d-block w-100" alt="GOD of WAR">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>God of War Incələmə</h3>
                        <p style="color: yellow">GamingBaku nə düşünür?</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="5.jpg" class="d-block w-100" alt="GOD of WAR">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Red Dead Redemption 2-dən yeni xəbərlər var</h3>
                        <p style="color: yellow">Yeni RDR gəlir</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="3.jpg" class="d-block w-100" alt="HITMAN">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Yeni Hitman oyunu gəlir!</h3>
                        <p style="color: yellow">Daha çox oyun, daha çox oyun</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <div class="col-4" style="margin-right: 50px">
        <img src="https://backstage.blogs.com/.a/6a00d8341c9cc153ef0120a9030ac0970b-600wi"
             style="width: 433px; height: 422px; position: relative">
        <div>
            <%--<h1 style="color: red; text-align: center; font-family: Calibri; position: absolute; bottom: 20px; left: 80px">--%>
            <%--BƏS REKLAMLAR?</h1>--%>
        </div>
    </div>
</div>

<%--News List--%>
<div class="newspanel row">
    <div class="newshead">
        <span style="color: black; font-size: 25px"><strong>XƏBƏR LENTİ</strong></span>
    </div>
    <div class="news-list">
        <ul class="list-unstyled">
            <li class="media">
                <a href="https://www.facebook.com/gamingbaku/?modal=admin_todo_tour" role="button"
                   rel="Ghost of Tsushima">
                </a>
                <figure class="figure">
                    <img src="https://cdn.mos.cms.futurecdn.net/jKyZh7AmtzFheyg3GWUn3k.jpg"
                         class="figure-img img-fluid rounded" alt="GHOST OF TSUSHIMA">
                </figure>
                <div class="media-body">
                    <h5 class="mt-0 mb-1">Ghost of Tsushima yaradıcısı studiyasından yeni açıqlamalar var!</h5>
                    Son vaxtlar Ghost of Tsushima ilə gündəmdə olan Sucker Punch'ın təxirə salınmış başqa bir oyunundan
                    12 dəqiqəlik oynanış videosu yayılıb. Oyunun kod adı #Prophecy'dir. Baş xarakter şəhərdə
                    axtarışdadır və canını qurtarmaq üçün əlindən gələni etməlidir.
                    Oyunun hansı səbəbdən təxirə düşdüyü tam bilinməsə də, bizim təxminimizcə Ghost of Tsushima'dan öncə
                    Sucker Punch'ın ağlında 3 muşketyor bənzəri oyun bu imiş...
                    <br/>
                    <strong> Sucker Punch Productions'dan maraqlı açıqlamalar gəldi! </strong>
                </div>
            </li>
            <li class="media">
                <figure class="figure">
                    <img src="https://image-cdn.essentiallysports.com/wp-content/uploads/20200621134318/3682297-the-last-of-us-part-ii-review-promothumb.jpg"
                         class="figure-img img-fluid rounded" alt="LAST OF US">
                </figure>
                <div class="media-body">
                    <h5 class="mt-0 mb-1">The Last of Us Part 2 İncələmə!</h5>
                    The Last of Us Part 2 ilin oyunu seçilsin deyə Ellie indidən səs yığmağa çalışır. Qeydiyat şəxsən
                    Ellie tərəfindən həyata keçirilir
                    <br/>
                    <strong> Oyun Metacritic'də tənqid yağışına tutuldu! </strong>
                </div>
            </li>
            <li class="media">
                <figure class="figure">
                    <img src="https://www.thumbsticks.com/wp-content/uploads/2020/07/epic-games-logo.jpg"
                         class="figure-img img-fluid rounded" alt="EPİC GAMES">
                </figure>
                <div class="media-body">
                    <h5 class="mt-0 mb-1">Epic Games uğurlarına davam edir</h5>
                    Epic Games də öz oyunlarına Achievement sistemini gətirəcək. Yəni, #Steam’də və ya #Playstation
                    hesabımızda hər hansı tapşırığı yerinə yetirdiyimizdə qazandığımız Nailiyyətlər sistemi Epic Games
                    mağazasında olan oyunlar üçün də gəlir. Bu barədə hətta, #Trello üzərindən sorğu yaradan Epic Games,
                    Nailiyyət sisteminin yoxluğuna görə rəqiblərindən geri qalırdı...
                    <br/>
                    <strong> Haydi, Epic Games, göreyim seni! </strong>
                </div>
            </li>
            <li class="media">
                <figure class="figure">
                    <img src="https://appandphones.com/wp-content/uploads/2020/07/Every-free-PS4-game-coming-to-PlayStation-Plus-in-August-2020-%E2%80%93-Appandphones.jpg"
                         class="figure-img img-fluid rounded" alt="GHOST OF TSUSHIMA">
                </figure>
                <div class="media-body">
                    <h5 class="mt-0 mb-1">Playstation Plus Avqust ayı oyunları bəlli oldu!</h5>
                    Playstation Plus'un Avqust ayı üçün pulsuz oyunları artıq bəllidir: Modern Warfare 2 Campaign
                    Remastered və Fall Guys: Ultimate Knockout. Bugündən etibarən, yəni İyulun 28-dən COD: Modern
                    Warfare'ni yükləyib oynaya bilərsiniz. Digər oyun isə, Avqustun 4-ü çıxış edəcəyinə görə, həmin
                    tarixə kimi gözləməli olacayıq.
                    Bir məsələni də diqqətinizə çatdırmaq istəyirik ki, PS+ 10 illiyini qeyd etdiyi üçün, bir çox
                    istifadəçilərinin hesabına 10$ bəxşiş edib. PS+ istifadəçiləri, hesablarınızı yoxlayın
                    <br/>
                    <strong> Call of Duty: Modern Warfare 2 Remastered deyirik... </strong>
                </div>
            </li>
            <li class="media">
                <figure class="figure">
                    <img src="https://www.allkeyshop.com/blog/wp-content/uploads/The-Witcher-3-wild-hunt-game-image-04-e1494907482251.jpg"
                         class="figure-img img-fluid rounded" alt="GHOST OF TSUSHIMA">
                </figure>
                <div class="media-body">
                    <h5 class="mt-0 mb-1">The Witcher 3 üçün çox əcaib bir mod hazırlanıb!</h5>
                    The Witcher 3 üçün çox maraqlı bir mod hazırlanıb!
                    Netflix tərəfindən çəkilən Witcher serialında gördüyümüz Triss və Yennefer, oyunda əsl xarakterlərlə
                    əvəz olunub. Beləliklə, əgər serialdakı Triss və Yennefer xarakterlərini daha çox bəyənirdinizsə, bu
                    moddan istifadə edə bilərsiniz.
                    <br/>
                    <strong> Gül kimi oyunu nə günə saldız? </strong>
                </div>
            </li>
        </ul>
    </div>
</div>

<footer>

</footer>
<%
String s1 = new String();

%>
</body>
</html>
