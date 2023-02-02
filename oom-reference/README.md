## oom-reference
* OOM 을 발생시키고, 힙덤프 분석.
* gradle application plugins 를 이용
* StrongReference vs SoftReference vs WeakReference 비교
  * [visualVM 으로 지표 비교](./README-visualvm.md)
* gc 관련 옵션
  * `java9이상`
    * -Xlog:gc*
    * -Xlog:gc*::time (디테일한 시간까지 본다.)
    * -Xlog:gc*:file=gc.log,filecount=5,filesize=50m (GC 로그 로테이션 및 파일 설정)
  * `java9미만`
    * -verbose:gc (가비지 컬렉터 정보 콘솔 출력) 
    * -XX:+UseGCLogFileRotation (GC 로그 로테이션 여부)
    * -XX:GCLogFileSize=50m (GC 로그 사이즈)
    * -XX:NumberOfGCLogFiles=5 (GC 로그 갯수)
    * -Xloggc:/log/gc.log (GC 로그 경로 및 파일 지정)
    * -XX:+PrintGCDetails (디테일하게 노출)
    * -XX:+PrintGCTimeStamps (GC 발생 시간 : 애플리케이션 띄어지고 나서 경과된 시간)
    * -XX:+PrintGCDateStamps (GC 발생 시간 : 현재 설정된 타임존 시간 기준)

## reference
* [gradle application plugins](https://docs.gradle.org/current/userguide/application_plugin.html)

