const CACHE_NAME = 'sales-monitoring-cache-v1';
const urlsToCache = [
  '/',
  '/index.html'
  // अन्य आवश्यक फाइलें (यदि कोई हो) जोड़ें
];

self.addEventListener('install', event => {
  event.waitUntil(
    caches.open(CACHE_NAME)
      .then(cache => cache.addAll(urlsToCache))
  );
});

self.addEventListener('fetch', event => {
  event.respondWith(
    caches.match(event.request)
      .then(response => response || fetch(event.request))
  );
});
