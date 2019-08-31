export function getVideoId(videoUrl) {
  const videoLink = videoUrl
  const videoLinkSplit = videoLink.split('v=')
  return videoLinkSplit.length !== 2 ? null : videoLinkSplit[1]
}
