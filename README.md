# Мобильная разработка УПС 2026

## Сделано:
* Верстка по шаблону
* Интеграция с API Яндекс.Карт
* Хардкод курсов и точек на карте
* Splash-экран с использованием фрагмента

## Скриншоты
<details>
<summary>Скриншоты (нажмите, чтобы развернуть)</summary>
    <table>
        <tr>
            <td>
                <img src="/assets/Screenshot_20250930-211425_UpsMobile.png" />
            </td>
            <td>
                <img src="/assets/Screenshot_20250930-211430_UpsMobile.png" />
            </td>
            <td>
                <img src="/assets/Screenshot_20250930-211549_UpsMobile.png" />
            </td>
        </tr>
    </table>
</details>

## Сборка
Проект собирается как обычный проект в Android Studio.  
Не забудьте указать API-ключ для Яндекс.Карт в файле `local.properties`:
```properties
MAPKIT_API_KEY=ваш_ключ_здесь
```