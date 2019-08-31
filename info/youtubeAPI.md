# YouTube API Info

### 특정 video의 comments list 가져오기
- **GET** `/video/{videoId}/comments?limit={limit}`
    - limit: 추첨할 댓글 개수
- response
    - 댓글 게시한 시간 (`items[x].snippet.topLevelComment.snippet.publishedAt`)
    - 좋아요 count (`items[x].snippet.topLevelComment.snippet.likeCount`) 등
    - 예시
        ```json
        [
            {
                "authorId": "UCjD-oOu2vYr6ECsTfkjsPmQ",
                "authorName": "노영준",
                "order": 317,
                "likeCount": 853,
                "totalPoint": 1625.8999999999999
            },
            {
                "authorId": "UC6dVegRJ5k0oMgvedwEqlIA",
                "authorName": "J1",
                "order": 334,
                "likeCount": 634,
                "totalPoint": 1395.4
            },
            {
                "authorId": "UCeZMTIsoOlh4hMlbdkKRkLg",
                "authorName": "보기자세히",
                "order": 234,
                "likeCount": 747,
                "totalPoint": 1341
            },
            ...
        ]
        ```
- YouYube API 호출 예시
    - `https://www.googleapis.com/youtube/v3/commentThreads?key={DEVELOPER_API_KEY}&part=snippet&maxResults=7&videoId=s-JNT4VInH8&textFormat=plainText`
- [YouTube API 참조 문서](https://developers.google.com/youtube/v3/docs/commentThreads/list)
    


### 특정 Channel의 video list 가져오기
- **GET** `/channel/{channelId}/videos`
- response
    - 각 video의 고유 id (`items[x].id.videoId`)
    - 각 video의 제목 (`items[x].snippet.title`)
    - 각 video의 썸네일 이미지 링크 (`items[x].snippet.thumbnails.url`) 등
    - 예시
        ```json
        {
         "kind": "youtube#searchListResponse",
         "etag": "\"8jEFfXBrqiSrcF6Ee7MQuz8XuAM/rPEFV-riOCD69x346rfpOxkmqQo\"",
         "nextPageToken": "CAIQAA",
         "regionCode": "KR",
         "pageInfo": {
          "totalResults": 48,
          "resultsPerPage": 2
         },
         "items": [
          {
           "kind": "youtube#searchResult",
           "etag": "\"8jEFfXBrqiSrcF6Ee7MQuz8XuAM/_l758Xx3QKH9c7eo7hLxsUL_gic\"",
           "id": {
            "kind": "youtube#video",
            "videoId": "s-JNT4VInH8"
           },
           "snippet": {
            "publishedAt": "2019-08-27T16:48:23.000Z",
            "channelId": "UC-L-qDH7L_d6rLFkxwWmsXQ",
            "title": "악기 칼림바의 장단점",
            "description": "안녕하세요 차니찬입니다. 늦은 시간에 올려서 잠을 방해하신건 아닌가 몰라요ㅠㅠ 이번 영상은 악기로써 칼림바의 장점 3가지와 단점 3가지를...",
            "thumbnails": {
             "default": {
              "url": "https://i.ytimg.com/vi/s-JNT4VInH8/default.jpg",
              "width": 120,
              "height": 90
             },
             "medium": {
              "url": "https://i.ytimg.com/vi/s-JNT4VInH8/mqdefault.jpg",
              "width": 320,
              "height": 180
             },
             "high": {
              "url": "https://i.ytimg.com/vi/s-JNT4VInH8/hqdefault.jpg",
              "width": 480,
              "height": 360
             }
            },
            "channelTitle": "Chani Chan",
            "liveBroadcastContent": "none"
           }
          },
          {
           "kind": "youtube#searchResult",
           "etag": "\"8jEFfXBrqiSrcF6Ee7MQuz8XuAM/25uWHhJp-r7EGllcu1DguXMuDgU\"",
           "id": {
            "kind": "youtube#video",
            "videoId": "HgWOYy-PEo0"
           },
           "snippet": {
            "publishedAt": "2019-08-16T18:07:08.000Z",
            "channelId": "UC-L-qDH7L_d6rLFkxwWmsXQ",
            "title": "루아우 칼림바 3개를 비교해보았다",
            "description": "안녕하세요 차니찬입니다. 이번 영상에서는 위키위키 제품의 루아우 칼림바 3종을 리뷰해보았습니다. 루아우 칼림바는 대나무 칼림바, 캠퍼우드...",
            "thumbnails": {
             "default": {
              "url": "https://i.ytimg.com/vi/HgWOYy-PEo0/default.jpg",
              "width": 120,
              "height": 90
             },
             "medium": {
              "url": "https://i.ytimg.com/vi/HgWOYy-PEo0/mqdefault.jpg",
              "width": 320,
              "height": 180
             },
             "high": {
              "url": "https://i.ytimg.com/vi/HgWOYy-PEo0/hqdefault.jpg",
              "width": 480,
              "height": 360
             }
            },
            "channelTitle": "Chani Chan",
            "liveBroadcastContent": "none"
           }
          }
         ]
        }
        ```
- YouTube API 호출 예시
    - `https://www.googleapis.com/youtube/v3/search?key={DEVELOPER_API_KEY}&part=snippet&order=date&maxResults=2&channelId=UC-L-qDH7L_d6rLFkxwWmsXQ`
- [YouTube API 참조 문서](https://developers.google.com/youtube/v3/docs/search/list)



### 특정 Channel의 구독자 정보 가져오기
- **GET** `/channel/{channelId}/subscriptions`
- 댓글을 게시한 사람이 구독 중인 구독자 리스트를 가져온 뒤, video를 게시한 channel을 해당 댓글 게시자가 구독 중인지 판단하기 위함 
- response
    - 특정 channel이 구독중인 다른 channel의 id (`items[x].snippet.channelId`)
    - 예시
        ```json
        {
         "kind": "youtube#subscriptionListResponse",
         "etag": "\"8jEFfXBrqiSrcF6Ee7MQuz8XuAM/r2eVrGR5tByK636I4TmlxXYiPL4\"",
         "nextPageToken": "CAIQAA",
         "pageInfo": {
          "totalResults": 76,
          "resultsPerPage": 2
         },
         "items": [
          {
           "kind": "youtube#subscription",
           "etag": "\"8jEFfXBrqiSrcF6Ee7MQuz8XuAM/wH-yCKRkPNtM4vuj2DJR6dohqpI\"",
           "id": "Hmf95akQzzME2Sm0coGyQZKqfnH5xyEwdYfbQHPF_JE",
           "snippet": {
            "publishedAt": "2018-01-19T19:40:22.497Z",
            "title": "Abi S",
            "description": "영국 | 한국 | 한국어를 배우는 아가씨 | 음식 \n\nEnough procrastination, time to do what I've been meaning to do for a while now!\n\nI'm using this channel as a platform to help people that are trying to make their English more natural or are interested in British culture and want to learn more about it. It's also a platform for people that are a lover of Korean culture and language.\n\n저는 이 채널을 영어를 좀더 자연스럽게 하거나 영국 문화에 대한 배우고 싶은 사람들을 돕기 위해서 플렛폼으로 사용하고 있습니다. 또한, 한국 문화와 언어를 사랑하는 사람들을 위해 플렛폼입니다.\n\nInstagram: abisoyes",
            "resourceId": {
             "kind": "youtube#channel",
             "channelId": "UCnHZem0Y3ijPeCuT-hRsE6w"
            },
            "channelId": "UCHpIHu4LzmNuD8bsE6mZLSA",
            "thumbnails": {
             "default": {
              "url": "https://yt3.ggpht.com/-xRH-wpVaLs8/AAAAAAAAAAI/AAAAAAAAAAA/joRh8JXUp6Q/s88-c-k-no-mo-rj-c0xffffff/photo.jpg"
             },
             "medium": {
              "url": "https://yt3.ggpht.com/-xRH-wpVaLs8/AAAAAAAAAAI/AAAAAAAAAAA/joRh8JXUp6Q/s240-c-k-no-mo-rj-c0xffffff/photo.jpg"
             },
             "high": {
              "url": "https://yt3.ggpht.com/-xRH-wpVaLs8/AAAAAAAAAAI/AAAAAAAAAAA/joRh8JXUp6Q/s800-c-k-no-mo-rj-c0xffffff/photo.jpg"
             }
            }
           }
          },
          {
           "kind": "youtube#subscription",
           "etag": "\"8jEFfXBrqiSrcF6Ee7MQuz8XuAM/L-dK8528h6H4vIDPzlOha1HRsKc\"",
           "id": "Hmf95akQzzME2Sm0coGyQWLb6GWKAlh3gBlog1yoTcg",
           "snippet": {
            "publishedAt": "2018-04-21T07:22:30.650Z",
            "title": "Anthony Ryu",
            "description": "",
            "resourceId": {
             "kind": "youtube#channel",
             "channelId": "UCPEKwh39c_wtICrD7TtRkTw"
            },
            "channelId": "UCHpIHu4LzmNuD8bsE6mZLSA",
            "thumbnails": {
             "default": {
              "url": "https://yt3.ggpht.com/-meEZTE4OWk4/AAAAAAAAAAI/AAAAAAAAAAA/tSIz7ENy81Y/s88-c-k-no-mo-rj-c0xffffff/photo.jpg"
             },
             "medium": {
              "url": "https://yt3.ggpht.com/-meEZTE4OWk4/AAAAAAAAAAI/AAAAAAAAAAA/tSIz7ENy81Y/s240-c-k-no-mo-rj-c0xffffff/photo.jpg"
             },
             "high": {
              "url": "https://yt3.ggpht.com/-meEZTE4OWk4/AAAAAAAAAAI/AAAAAAAAAAA/tSIz7ENy81Y/s800-c-k-no-mo-rj-c0xffffff/photo.jpg"
             }
            }
           }
          }
         ]
        }
        ```
- YouTube API 호출 예시
    - `https://www.googleapis.com/youtube/v3/subscriptions?key={DEVELOPER_API_KEY}&part=snippet&maxResults=2&channelId=UCHpIHu4LzmNuD8bsE6mZLSA`
- [YouTube API 참조 문서](https://developers.google.com/youtube/v3/docs/subscriptions/list)



### 어떤 댓글 게시자가 특정 channel에 얼마나 자주 댓글을 남겼는지
- *holding* 상태
- **GET** `/channel/{channelId}/replies/...`
- response
    - 예시
        ```json
        {
         "items": [
          {
           "authorChannelId": "dfsdf",
           "replyCount": 28
          },
          {
           "authorChannelId": "dfsdf",
           "replyCount": 2
          }
         ]
        }
        ```